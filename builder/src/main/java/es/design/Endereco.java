package es.design;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Endereco {

    @NonNull
    private String rua;

    private String setor;
    private String cep;
    private int numero;
    private String cidade;
    private String estado;
    private String bloco;
    private String complemento;

}
