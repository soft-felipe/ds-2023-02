package es.design;

import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Util {
    protected Path getPathResource(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            System.out.println("Deu ruim! Arquivo não encontrado");
            return null;
        }

        URI uri = null;
        try {
            uri = resource.toURI();
        } catch (Exception e) {
            return null;
        }

        return Paths.get(uri);
    }
}
