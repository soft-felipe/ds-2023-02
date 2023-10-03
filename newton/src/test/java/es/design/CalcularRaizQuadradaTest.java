package es.design;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalcularRaizQuadradaTest {

    @Test
    public void numerosPositivosTest() throws Exception {
        assertEquals(2.0, CalcularRaizQuadrada.calcularRaizQuadrada(4.0, 1e-06), 0.001);
        assertEquals(3.0, CalcularRaizQuadrada.calcularRaizQuadrada(9.0, 1e-06), 0.001);
        assertEquals(4.0, CalcularRaizQuadrada.calcularRaizQuadrada(16.0, 1e-06), 0.001);
        assertEquals(5.0, CalcularRaizQuadrada.calcularRaizQuadrada(25.0, 1e-06), 0.001);
        assertEquals(6.0, CalcularRaizQuadrada.calcularRaizQuadrada(36.0, 1e-06), 0.001);
    }

    @Test
    public void numeroZeroTest() throws Exception {
        assertEquals(0.0, CalcularRaizQuadrada.calcularRaizQuadrada(0, 0.001), 0.001);
    }

    @Test
    public void numeroNegativoTest() {
        assertThrows(Exception.class, () -> CalcularRaizQuadrada.calcularRaizQuadrada(-2, 1e-06));
        assertThrows(Exception.class, () -> CalcularRaizQuadrada.calcularRaizQuadrada(-30, 1e-06));
        assertThrows(Exception.class, () -> CalcularRaizQuadrada.calcularRaizQuadrada(-1, 1e-06));
    }

    @Test
    public void numerosSemRaizExata() throws Exception {
        /* Realizando testes para números com alta precisão, com raízes não exatas */
        assertEquals(1.414213562373095, CalcularRaizQuadrada.calcularRaizQuadrada(2.0, 0.001), 0.001);
        assertEquals(1.7320508075688772, CalcularRaizQuadrada.calcularRaizQuadrada(3.0, 0.001), 0.001);
        assertEquals(3.1622776601683795, CalcularRaizQuadrada.calcularRaizQuadrada(10.0, 0.001), 0.001);
    }
}
