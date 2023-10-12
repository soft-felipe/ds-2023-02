package es.design.interfaces;

import es.design.implementacao.Celula;

public interface Observador {
    /* Por meio desse método da interface é responsabilidade do Observador saber o que fazer quando for notificado
    * de uma alteração na célula observada, como na implementação da CelulaRealizaSoma */
    void atualiza(Celula celula);
}
