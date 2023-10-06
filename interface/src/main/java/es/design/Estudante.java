package es.design;

import java.util.List;

public class Estudante {

    private String nome;
    private String sobrenome;
    private int idade;
    private List<Double> notas;

    public Estudante(String nome, String sobrenome, int idade, List<Double> notas) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.notas = notas;
    }

    public double getMedia() {
        return this.notas.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public List<Double> getNotas() {
        return notas;
    }
}
