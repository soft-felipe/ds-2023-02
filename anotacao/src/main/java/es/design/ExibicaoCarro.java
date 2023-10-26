package es.design;

@Observer(observado = "es.design.Carro")
public class ExibicaoCarro implements ObservadorCarro {
    private String nome;

    public ExibicaoCarro(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(Carro carro) {
        System.out.println(nome + " - Modelo: " + carro.getModelo() + ", Velocidade: " + carro.getVelocidade() + " km/h");
    }
}
