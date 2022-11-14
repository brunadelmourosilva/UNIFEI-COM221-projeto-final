package br.unifei.imc.lojaprodutosconsumer.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoMessage {

    private String name;

    private Double price;

    private Integer quantity; //todo front

    private String image;
}
