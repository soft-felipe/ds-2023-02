package es.design;

import java.util.ArrayList;
import java.util.List;

public class Carro implements Observado {

    private String modelo;
    private double velocidade;
    private List<Observador> observadoresDaClasse = new ArrayList<>();

    public Carro(String modelo) {
        this.modelo = modelo;
        this.velocidade = 0;
    }

    @Override
    public String getInfos() {
        return "Modelo: " + modelo + " Velocidade: " + velocidade;
    }

    @Override
    public void adicionarObservador(Observador... observadores) {

        for (Observador observador : observadores) {
            if (!observador.getClass().isAnnotationPresent(Observer.class)) continue;
            if (observador.getClass().getAnnotation(Observer.class).observado().equals(Carro.class)) {
                observadoresDaClasse.add(observador);
            }
        }
    }

    public void acelerar(double novaVelocidade) {
        this.velocidade = novaVelocidade;
        notificarObservadores();
    }

    private void notificarObservadores() {
        observadoresDaClasse.forEach(observador -> observador.atualizar(this));
    }

    public String getModelo() {
        return modelo;
    }

    public double getVelocidade() {
        return velocidade;
    }
}

