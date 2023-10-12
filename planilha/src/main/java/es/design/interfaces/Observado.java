package es.design.interfaces;

import es.design.implementacao.Celula;

public interface Observado {
    void adicionaObservador(Observador observador);
    void removeObservador(Observador observador);
    void notificaObservadores(Celula celula);
}
