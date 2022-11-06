package br.unifei.imc.lojaprodutosconsumer.messages;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class FinalizaPedidoMessage {

    private Integer payment;

    private EnderecoMessage endereco;

    private List<ProdutoMessage> produtos;

    private Double valorTotal;

}
