package es.design;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSV {
    public static void main(String[] args) {
        Util util = new Util();
        try (BufferedReader reader = new BufferedReader(new FileReader(util.getPathResource("input.csv").toString()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(util.getPathResource("output.csv").toString()))
        ) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] parts = linha.split(",");
                try {
                    double num1 = Double.parseDouble(parts[0]);
                    double num2 = Double.parseDouble(parts[1]);
                    double sum = num1 + num2;
                    writer.write(parts[0] + "," + parts[1] + "," + sum);
                    writer.newLine();
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter números na linha: " + linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

