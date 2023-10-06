package es.design;

import java.util.Comparator;

public class EstudantePorSobrenomeComparator implements Comparator<Estudante> {
    @Override
    public int compare(Estudante o1, Estudante o2) {
        return o1.getSobrenome().compareTo(o2.getSobrenome());
    }
}
