package br.unifei.imc.lojaprodutos.dto.request;

import br.unifei.imc.lojaprodutos.models.Cidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoRequest {

    private Integer id; //todo tirar depois

    private String street;

    private String number;

    private String complement;

    private String neighborhood;

    private String zipCode;

    private CidadeRequest city;

}
