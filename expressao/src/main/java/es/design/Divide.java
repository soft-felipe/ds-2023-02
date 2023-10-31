package es.design;

public class Divide implements Expressao {

    private float constante1;
    private float constante2;

    public Divide(float constante1, float constante2) {
        this.constante1 = constante1;
        this.constante2 = constante2;
    }

    @Override
    public float valor() throws ArithmeticException {
        if (constante2 == 0) throw new ArithmeticException("Divisão por 0!");
        return constante1 / constante2;
    }
}
