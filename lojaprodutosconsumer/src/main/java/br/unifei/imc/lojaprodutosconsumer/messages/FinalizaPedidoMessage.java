package br.unifei.imc.lojaprodutosconsumer.messages;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class FinalizaPedidoMessage {

    private Integer id;

    private Date date;

    private ClienteMessage customer;

    private List<ProdutoMessage> products;

    private EnderecoMessage address;

    private Double totalPrice;

    private Integer payment;

    private String randomKey;
}
