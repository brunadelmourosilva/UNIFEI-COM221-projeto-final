package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.builders.CartaoBuilder;
import br.unifei.imc.lojaprodutos.models.Cartao;
import br.unifei.imc.lojaprodutos.models.Cliente;

import java.util.List;

public class CartaoFactory {

  public static List<Cartao> createCartoes(Cliente c1) {

    return List.of(
        CartaoBuilder.builder()
            .cardNumber("123 789 234")
            .validity("09/24")
            .securityCode("345")
            .cliente(c1)
            .build());
  }
}
