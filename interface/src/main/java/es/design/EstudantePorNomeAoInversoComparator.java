package es.design;

import java.util.Comparator;

public class EstudantePorNomeAoInversoComparator implements Comparator<Estudante> {
    @Override
    public int compare(Estudante o1, Estudante o2) {
        return o2.getNome().compareTo(o1.getNome());
    }
}
