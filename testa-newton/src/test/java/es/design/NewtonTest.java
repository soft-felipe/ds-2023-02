package es.design;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class NewtonTest {

    @Test
    public void testandoCalcularRaizQuadradaPorDependencia() {
        Function<Double, Double> implementacaoDoNewton = getObject("es.design.CalcularRaizQuadrada");
        assertEquals(3.0, implementacaoDoNewton.apply(9.0), 0.01);
    }

    private static Function<Double, Double> getObject(String classname) {
        try {
            Class<?> classe = Class.forName(classname);
            return (Function<Double,Double>)
                    classe.getDeclaredConstructors()[0].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
