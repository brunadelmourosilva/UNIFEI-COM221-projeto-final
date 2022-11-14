package br.unifei.imc.lojaprodutos.senders.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoMessage {

    private String name;

    private Double price;

    //private Integer quantity; //todo

    private String image;
}
