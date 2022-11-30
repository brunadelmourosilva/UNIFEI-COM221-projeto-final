package br.unifei.imc.lojaprodutos.builders;

import br.unifei.imc.lojaprodutos.models.Cartao;
import br.unifei.imc.lojaprodutos.models.Cliente;

public class CartaoBuilder {

  private String cardNumber;

  private String validity;

  private String securityCode;

  private Cliente cliente;

  public static CartaoBuilder builder() {
    return new CartaoBuilder();
  }

  public CartaoBuilder cardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

  public CartaoBuilder validity(String validity) {
    this.validity = validity;
    return this;
  }

  public CartaoBuilder securityCode(String securityCode) {
    this.securityCode = securityCode;
    return this;
  }

  public CartaoBuilder cliente(Cliente cliente) {
    this.cliente = cliente;
    return this;
  }

  public Cartao build() {
    return new Cartao(cardNumber, validity, securityCode, cliente);
  }
}
