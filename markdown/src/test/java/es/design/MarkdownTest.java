package es.design;

import es.design.implementacao.Texto;
import es.design.implementacao.decorators.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;

public class MarkdownTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    public void tituloTest() {
        Markdown markdown = new Texto("Título");
        new Titulo(markdown).exibe();

        String textoNoTerminal = outContent.toString().trim();
        assertEquals("# Título", textoNoTerminal);
    }

    @Test
    public void negritoEItalicoTest() {
        Markdown markdown = new Concatena(new Texto("Uma simples linha, com "), new Concatena(new Negrito(new Texto("negrito")), new Concatena(new Texto(" e "), new Italico(new Texto("itálico")))));
        markdown.exibe();

        String textoNoTerminal = outContent.toString().trim();
        assertEquals("Uma simples linha, com **negrito** e _itálico_", textoNoTerminal);
    }

    @Test
    public void itemTest() {
        Markdown markdown = new Concatena(new Texto("Primeiro item da linha com "), new Italico(new Texto("itálico")));
        new Item(markdown).exibe();

        String textoNoTerminal = outContent.toString().trim();
        assertEquals("- Primeiro item da linha com _itálico_", textoNoTerminal);
    }
}
