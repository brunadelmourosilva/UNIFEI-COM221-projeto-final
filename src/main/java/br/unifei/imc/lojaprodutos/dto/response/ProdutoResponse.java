package br.unifei.imc.lojaprodutos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoResponse {

    private Integer id;

    private String name;

    private Double price;

    private String image;
}
