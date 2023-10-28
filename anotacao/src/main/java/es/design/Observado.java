package es.design;

public interface Observado {
    String getInfos();
    void adicionarObservador(Observador... observadores);
}
