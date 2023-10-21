package es.design;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

public class ProcuraClasses {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("A entrada está errada!\nExemplo esperado: fc <nome da classe> <dir> [-p]");
            return;
        }

        String nomeClasse = args[0];
        File pathDiretorio = new File(args[1]);
        boolean usarParallelStream = args.length > 2 && args[2].equals("-p");

        try {
            long iniciou = System.currentTimeMillis();
            List<File> classesEncontradas = procurarClasse(nomeClasse, pathDiretorio, usarParallelStream);
            long terminou = System.currentTimeMillis();

            System.out.println("Arquivos encontrados: ");
            classesEncontradas.forEach(classeEncontrada -> {
                System.out.println(classeEncontrada.getAbsolutePath());
            });
            long diff = terminou - iniciou;
            System.out.println("Tempo total gasto: " + diff + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<File> procurarClasse(String nomeClasse, File diretorio, boolean usarParallelStream) {
        List<File> classesEncontradas = new ArrayList<>();

        try (Stream<File> streamFile = listarArquivosDiretorio(diretorio, usarParallelStream)) {
            streamFile.forEach(arquivoEncontrado -> {
                if (arquivoEncontrado.getName().endsWith(".class")) {
                    String nomeArquivoClass = getNomeArquivoClass(arquivoEncontrado.getName());
                    if (nomeArquivoClass.equals(nomeClasse)) classesEncontradas.add(arquivoEncontrado);
                } else if (arquivoEncontrado.getName().equals(".jar") || arquivoEncontrado.getName().equals(".war")) {
                    buscaArquivoClassEmJarWar(classesEncontradas, arquivoEncontrado, nomeClasse);
                }
            });
        }

        return classesEncontradas;
    }

    private static String getNomeArquivoClass(String nomeArquivo) {
        return nomeArquivo.substring(0, nomeArquivo.length() - 6);
    }

    private static Stream<File> listarArquivosDiretorio(File diretorio, boolean usarParallelStream) {
        Stream<File> streamFile = usarParallelStream ? Stream.of(diretorio.listFiles()).parallel() : Stream.of(diretorio.listFiles()).sequential();
        return streamFile.flatMap(file -> {
            if (file.isDirectory()) {
                return listarArquivosDiretorio(file, usarParallelStream);
            } else {
                return Stream.of(file);
            }
        });
    }

    private static void buscaArquivoClassEmJarWar(List<File> arquivosEncontrados, File arquivoJarWarEncontrado, String nomeArquivo) {
        List<String> arquivosClassEncontradosNoJarWar = new ArrayList<>();

        try (JarFile jarFile = new JarFile(arquivoJarWarEncontrado)) {
            Enumeration<JarEntry> entries = jarFile.entries();

            while (entries.hasMoreElements()) {
                JarEntry jarEntry = entries.nextElement();
                if (jarEntry.getName().endsWith(".class")) {
                    String name = jarEntry.getName().replace("/", ".");
                    name = getNomeArquivoClass(name);
                    arquivosClassEncontradosNoJarWar.add(name);
                }
            }

            arquivosClassEncontradosNoJarWar.forEach(arquivoEncontrado -> {
                if (arquivoEncontrado.equals(nomeArquivo)) arquivosEncontrados.add(new File(arquivoEncontrado));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
