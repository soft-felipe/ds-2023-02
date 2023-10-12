package es.design.implementacao;

import es.design.interfaces.Observado;
import es.design.interfaces.Observador;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Celula implements Observado {

    private final String nome;
    private String valor;
    private List<Observador> observadores = new ArrayList<>();

    public Celula(String nome) {
        this.nome = nome;
    }

    public void setValor(String novoValor) {
        if (!this.valor.equals(novoValor)) {
            this.valor = novoValor;

        }
    }

    @Override
    public void adicionaObservador(Observador observador) {
        this.observadores.add(observador);
    }

    @Override
    public void removeObservador(Observador observador) {
        this.observadores.remove(observador);
    }

    @Override
    public void notificaObservadores(Celula celula) {
        observadores.forEach(observador -> observador.atualiza(celula));
    }
}
