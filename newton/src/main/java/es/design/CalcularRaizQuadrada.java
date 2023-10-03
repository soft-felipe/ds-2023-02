package es.design;

public class CalcularRaizQuadrada {
    public static double calcularRaizQuadrada(double numero, double tolerancia) throws Exception {
        if (numero < 0) throw new Exception("Número negativo não possui raíz!");

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
}