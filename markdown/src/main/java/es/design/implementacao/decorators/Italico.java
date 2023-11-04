package es.design.implementacao.decorators;

import es.design.Markdown;
import es.design.implementacao.MarkdownDecorator;

public class Italico extends MarkdownDecorator {

    public Italico(Markdown markdown) {
        super(markdown);
    }

    @Override
    public void exibe() {
        System.out.print("_");
        markdown.exibe();
        System.out.print("_");
    }
}
