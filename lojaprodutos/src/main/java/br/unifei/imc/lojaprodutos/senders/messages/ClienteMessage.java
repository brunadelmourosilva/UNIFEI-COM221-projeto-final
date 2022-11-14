package br.unifei.imc.lojaprodutos.senders.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteMessage {

    private String name;

    private String email;

    private CartaoMessage card;
}
