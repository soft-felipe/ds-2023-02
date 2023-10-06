package es.design;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class OrdenaEstudanteTest {

    Estudante alice = new Estudante("Alice",
            "Silva",
            20,
            Arrays.asList(8.5, 9.0, 7.2)
    );

    Estudante bruno = new Estudante("Bruno",
            "Moreira",
            22,
            Arrays.asList(3.1, 9.7, 6.0)
    );

    @Test
    public void testaOrdenacaoEstudantePorNomeComparator() {
        Estudante[] estudantesPrimeiroTeste = {alice, bruno};
        Arrays.sort(estudantesPrimeiroTeste, new EstudantePorNomeComparator());
        assertEquals("Alice", estudantesPrimeiroTeste[0].getNome());
        assertEquals("Bruno", estudantesPrimeiroTeste[1].getNome());
    }

    @Test
    public void testaOrdenacaoEstudantePorNomeAoInverso() {
        Estudante[] estudantesSegundoTeste = {alice, bruno};
        Arrays.sort(estudantesSegundoTeste, new EstudantePorNomeAoInversoComparator());
        assertEquals("Bruno", estudantesSegundoTeste[0].getNome());
        assertEquals("Alice", estudantesSegundoTeste[1].getNome());
    }

    @Test
    public void testaOrdenacaoEstudantePorSobrenomeComparator() {
        Estudante[] estudantesTerceiroTeste = {alice, bruno};
        Arrays.sort(estudantesTerceiroTeste, new EstudantePorSobrenomeComparator());
        assertEquals("Moreira", estudantesTerceiroTeste[0].getSobrenome());
        assertEquals("Silva", estudantesTerceiroTeste[1].getSobrenome());
    }

    @Test
    public void testaOrdenacaoEstudantePorIdadeComparator() {
        Estudante[] estudantesQuartoTeste = {alice, bruno};
        Arrays.sort(estudantesQuartoTeste, new EstudantePorIdadeComparator());
        assertEquals(20, estudantesQuartoTeste[0].getIdade());
        assertEquals(22, estudantesQuartoTeste[1].getIdade());
    }

    @Test
    public void testaOrdenacaoEstudantePorNotasComparator() {
        Estudante[] estudantesQuintoTeste = {alice, bruno};
        Arrays.sort(estudantesQuintoTeste, new EstudantePorNotasComparator());
        assertEquals(Arrays.asList(3.1, 9.7, 6.0), estudantesQuintoTeste[0].getNotas());
        assertEquals(Arrays.asList(8.5, 9.0, 7.2), estudantesQuintoTeste[1].getNotas());
    }

    @Test
    public void testaOrdenacaoEstudantePorMediaComparator() {
        Estudante[] estudantesSextoTeste = {alice, bruno};
        Arrays.sort(estudantesSextoTeste, new EstudantePorMediaComparator());
        assertEquals(6.26, estudantesSextoTeste[0].getMedia(), 0.01);
        assertEquals(8.23, estudantesSextoTeste[1].getMedia(), 0.01);
    }
}