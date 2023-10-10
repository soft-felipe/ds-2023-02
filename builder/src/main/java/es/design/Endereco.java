package es.design;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Endereco {

    private String rua;
    private String setor;
    private String cep;
    private int numero;
    private String cidade;
    private String estado;
    private String bloco;
    private String complemento;

}
