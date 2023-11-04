package es.design.implementacao.decorators;

import es.design.Markdown;
import es.design.implementacao.MarkdownDecorator;

public class Negrito extends MarkdownDecorator {

    public Negrito(Markdown markdown) {
        super(markdown);
    }

    @Override
    public void exibe() {
        System.out.print("**");
        markdown.exibe();
        System.out.print("**");
    }
}
