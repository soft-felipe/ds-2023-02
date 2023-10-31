package es.design;

public class Multiplica implements Expressao {

    private float constante1;
    private float constante2;

    public Multiplica(float constante1, float constante2) {
        this.constante1 = constante1;
        this.constante2 = constante2;
    }

    @Override
    public float valor() {
        return constante1 * constante2;
    }
}
