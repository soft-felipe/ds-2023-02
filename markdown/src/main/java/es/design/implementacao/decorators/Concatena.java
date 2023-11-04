package es.design.implementacao.decorators;

import es.design.Markdown;

public class Concatena implements Markdown {

    private Markdown primeiroTexto;
    private Markdown segundoTexto;

    public Concatena(Markdown primeiroTexto, Markdown segundoTexto) {
        this.primeiroTexto = primeiroTexto;
        this.segundoTexto = segundoTexto;
    }

    @Override
    public void exibe() {
        primeiroTexto.exibe();
        segundoTexto.exibe();
    }
}
