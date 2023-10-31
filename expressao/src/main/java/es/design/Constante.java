package es.design;

public class Constante implements Expressao {
    private float constante;

    public Constante(float constante) {
        this.constante = constante;
    }

    @Override
    public float valor() {
        return constante;
    }
}
