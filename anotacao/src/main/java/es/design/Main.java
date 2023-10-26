package es.design;

public class Main {
    public static void main(String[] args) {
        Carro celtinha = new Carro("Celtinha");
        ExibicaoCarro observador1 = new ExibicaoCarro("Quero ver o celtinha");
        ExibicaoCarro observador2 = new ExibicaoCarro("Estou acompanhando o brabo");

        celtinha.adicionarObservador(observador1, observador2);
        celtinha.acelerar(80);
        celtinha.acelerar(100);
    }
}
