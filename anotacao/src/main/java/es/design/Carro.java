package es.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carro {

    private String modelo;
    private double velocidade;
    private List<ObservadorCarro> observadores = new ArrayList<>();

    public Carro(String modelo) {
        this.modelo = modelo;
        this.velocidade = 0;
    }

    public void adicionarObservador(ObservadorCarro... observador) {
        observadores.addAll(Arrays.asList(observador));
    }

    public void acelerar(double novaVelocidade) {
        this.velocidade = novaVelocidade;
        notificarObservadores();
    }

    private void notificarObservadores() {
        observadores.forEach(observador -> observador.atualizar(this));
    }

    public String getModelo() {
        return modelo;
    }

    public double getVelocidade() {
        return velocidade;
    }
}

