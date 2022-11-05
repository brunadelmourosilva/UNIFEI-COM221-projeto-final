package br.unifei.imc.lojaprodutos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequest {

    private Integer id;

    private String name;

    private Double price;
    
    private String image;
    
}
