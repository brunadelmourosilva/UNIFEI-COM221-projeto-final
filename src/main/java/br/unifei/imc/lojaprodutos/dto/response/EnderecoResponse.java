package br.unifei.imc.lojaprodutos.dto.response;

import br.unifei.imc.lojaprodutos.models.Cidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnderecoResponse {

    private Integer id;

    private String rua;

    private String numero;

    private String complemento;

    private String bairro;

    private String cep;

    private CidadeResponse cidade;
}
