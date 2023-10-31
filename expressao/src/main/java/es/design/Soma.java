package es.design;

public class Soma implements Expressao {

    private float constante1;
    private float constante2;

    public Soma(float constante1, float constante2) {
        this.constante1 = constante1;
        this.constante2 = constante2;
    }

    @Override
    public float valor() throws ArithmeticException {
        return constante1 + constante2;
    }
}
