package es.design.implementacao;

import es.design.interfaces.Observador;

public class CelulaDependente implements Observador {

    protected final Celula celulaDependente;

    public CelulaDependente(Celula celulaObservadora, Celula celulaObservada) {
        this.celulaDependente = celulaObservadora;

        /* A célula observada tem um observador que é o próprio objeto CelulaDependente pois o observador
        * é dependente da observada */
        celulaObservada.adicionaObservador(this);
    }

    @Override
    public void atualiza(Celula celula) {
        System.out.println("Reavaliar " + celulaDependente.getNome() + " por mudança ocorrida em " + celula.getNome());
    }
}
