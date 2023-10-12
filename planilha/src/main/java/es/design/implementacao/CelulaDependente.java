package es.design.implementacao;

import es.design.interfaces.Observador;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CelulaDependente implements Observador {

    private final Celula celulaDependente;
    private final Logger log = LogManager.getLogManager().getLogger(CelulaDependente.class.getName());

    public CelulaDependente(Celula celulaDependente, Celula celulaObservada) {
        this.celulaDependente = celulaDependente;
        /* A célula observada tem um observador que é o próprio objeto CelulaDependente pois o observador
        * é dependente da observada */
        celulaObservada.adicionaObservador(this);
    }

    @Override
    public void atualiza(Celula celula) {
        log.info("Reavaliar" + celulaDependente.getNome() + "por mudança ocorrida em" + celula.getNome());
    }
}
