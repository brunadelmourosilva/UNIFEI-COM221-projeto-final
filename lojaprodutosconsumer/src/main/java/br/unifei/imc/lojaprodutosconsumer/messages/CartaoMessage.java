package br.unifei.imc.lojaprodutosconsumer.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaoMessage {

    private String cardNumber;

    private String validity;

    private String securityCode;
}
