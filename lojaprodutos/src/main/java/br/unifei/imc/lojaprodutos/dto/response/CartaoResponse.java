package br.unifei.imc.lojaprodutos.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

  @JsonIgnore private ClienteCartaoResponse cliente;
}
