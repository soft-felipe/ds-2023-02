package es.design;

import java.util.Comparator;

public class EstudantePorNotasComparator implements Comparator<Estudante> {
    @Override
    public int compare(Estudante o1, Estudante o2) {
        return Double.compare(o1.getMedia(), o2.getMedia());
    }
}
