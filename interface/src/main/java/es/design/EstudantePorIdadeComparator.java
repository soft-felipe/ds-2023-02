package es.design;

import java.util.Comparator;

public class EstudantePorIdadeComparator implements Comparator<Estudante> {
    @Override
    public int compare(Estudante o1, Estudante o2) {
        return Integer.compare(o1.getIdade(), o2.getIdade());
    }
}
