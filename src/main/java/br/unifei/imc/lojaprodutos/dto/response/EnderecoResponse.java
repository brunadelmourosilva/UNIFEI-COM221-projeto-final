package br.unifei.imc.lojaprodutos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnderecoResponse {

    private Integer id;

    private String street;

    private String number;

    private String complement;

    private String neighborhood;

    private CidadeResponse city;

}
