package es.design.implementacao;

import es.design.Markdown;

public class Texto implements Markdown {

    private String texto;

    public Texto(String texto) {
        this.texto = texto;
    }

    @Override
    public void exibe() {
        System.out.print(texto);
    }
}
