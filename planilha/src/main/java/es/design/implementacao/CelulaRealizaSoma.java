package es.design.implementacao;

public class CelulaRealizaSoma extends CelulaDependente {

    public CelulaRealizaSoma(Celula celulaDependente, Celula celulaObservada) {
        super(celulaDependente, celulaObservada);
    }

    @Override
    public void atualiza(Celula celula) {
        /* Imprimindo a notifição padrão */
        super.atualiza(celula);

        /* Realizamos a soma dos valores e atualizamos a celula dependente */
        Integer soma = Integer.parseInt(celulaDependente.getValor().isEmpty() ? "0" : celulaDependente.getValor());
        soma += Integer.parseInt(celula.getValor());
        celulaDependente.setValor(soma.toString());
    }
}
