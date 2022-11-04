package br.unifei.imc.lojaprodutos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartaoResponse {

    private String cardNumber;

    private String validity;

    private String securityCode;

    private ClienteCartaoResponse cliente;
}
