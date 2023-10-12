package es.design;

import es.design.implementacao.Celula;
import es.design.implementacao.CelulaDependente;
import es.design.implementacao.CelulaRealizaSoma;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CelulasTest {

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
    public void notificacaoPadraoTest() {
        Celula a1 = new Celula("A1"),
                a2 = new Celula("A2"),
                a3 = new Celula("A3");

        CelulaDependente dependenciaA3A1 = new CelulaDependente(a3, a1),
                         dependenciaA3A2 = new CelulaDependente(a3, a2);

        a1.setValor("10");
        a2.setValor("20");

        /* Capturando a mensagem do observado no terminal para verificars se notificou realmente :) */
        String notificaoNoTerminal = outContent.toString().trim();
        assertTrue(notificaoNoTerminal.contains("por mudança ocorrida em"));
    }

    @Test
    public void somandoCelulasTest() {
        Celula a1 = new Celula("A1"),
                a2 = new Celula("A2"),
                a3 = new Celula("A3");

        CelulaDependente dependenciaA3A1 = new CelulaRealizaSoma(a3, a1),
                dependenciaA3A2 = new CelulaRealizaSoma(a3, a2);

        a1.setValor("10");
        a2.setValor("10");

        assertEquals(20, Integer.parseInt(a3.getValor()));
    }
}
