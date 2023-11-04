package es.design.implementacao;

import es.design.Markdown;

public class MarkdownDecorator implements Markdown {

    protected Markdown markdown;

    public MarkdownDecorator(Markdown markdown) {
        this.markdown = markdown;
    }

    @Override
    public void exibe() {
        markdown.exibe();
    }
}
