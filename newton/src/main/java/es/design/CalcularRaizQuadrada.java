package es.design;

import java.util.function.Function;

public class CalcularRaizQuadrada implements Function<Double, Double> {
    public static double calcularRaizQuadrada(double numero, double tolerancia) throws Exception {
        if (numero == 0) return 0.0;

        double aproximacao = numero;
        double erro = 1;

        while (erro > tolerancia) {
            double proximaAproximacao = 0.5 * (aproximacao + numero / aproximacao);
            erro = Math.abs(aproximacao - proximaAproximacao);
            aproximacao = proximaAproximacao;
        }

        return aproximacao;
    }

    @Override
    public Double apply(Double aDouble) {
        try {
            return calcularRaizQuadrada(aDouble, 1e-06);
        } catch (Exception ignore) {}

        return 0.0;
    }
}