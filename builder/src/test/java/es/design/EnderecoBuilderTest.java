package es.design;

import org.junit.Test;

import static org.junit.Assert.*;

public class EnderecoBuilderTest {

    @Test
    public void instanciandoClasseEnderecoComBuilderTest() {
        Endereco enderecoTest = Endereco.builder()
                .rua("Avenida Feliz")
                .setor("Setor Alegria")
                .cep("90909-909")
                .numero(0)
                .cidade("Anapolis")
                .estado("Goias")
                .complemento("QD 01 LT 02")
                .build();

        assertEquals("Setor Alegria", enderecoTest.getSetor());
        assertEquals("Anapolis", enderecoTest.getCidade());
        assertEquals("QD 01 LT 02", enderecoTest.getComplemento());
    }

    @Test
    public void atributosNaoInstanciadosTest() {
        Endereco enderecoIncompletoTest = Endereco.builder()
                .rua("Rua de testes")
                .cidade("Goiania")
                .cep("87878.878")
                .build();

        assertEquals("Rua de testes", enderecoIncompletoTest.getRua());

        /* Atributos não instanciados serão NULOS! */
        assertEquals(null, enderecoIncompletoTest.getEstado());
        assertEquals(null, enderecoIncompletoTest.getBloco());
    }

    @Test
    public void atributosPreenchidosErradosTest() {
        Endereco enderecoErradoTest = Endereco.builder()
                .rua("Rua ERRADA")
                .cidade("BrasiliAA")
                .cep("00000.00")
                .build();

        assertNotEquals("Rua errada", enderecoErradoTest.getRua());
        assertNotEquals("Brasilia", enderecoErradoTest.getCidade());
        assertNotEquals(100, enderecoErradoTest.getNumero());
    }
}
