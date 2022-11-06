package br.unifei.imc.lojaprodutos.senders.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoMessage {

    private String name;

    private Double price;

    private String image;
}
