package es.design;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SomaTest {

    @Test
    public void testaSoma() {
        float valorFinal = new Soma(
                new Constante(5).valor(),
                new Multiplica(new Constante(2).valor(), new Constante(3).valor()).valor())
                .valor();

        assertEquals(Float.parseFloat("11"), valorFinal);
    }
}
