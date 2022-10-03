package br.unifei.imc.lojaprodutos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoResponse {

    private Integer id;

    private String nome;

    private Integer estoque;

    private Double preco;

    private String imageUrl;
}
