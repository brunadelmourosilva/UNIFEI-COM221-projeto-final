package br.unifei.imc.lojaprodutosconsumer.strategy;

import br.unifei.imc.lojaprodutosconsumer.messages.FinalizaPedidoMessage;
import br.unifei.imc.lojaprodutosconsumer.strategy.interfaces.PagamentoStrategy;
import lombok.AllArgsConstructor;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@AllArgsConstructor
public class CartaoStrategy implements PagamentoStrategy {

  private TemplateEngine templateEngine;

  private static final Double JUROS = 1.02;

  /** For CARD type payment, there will be a 0.02% extra on the total purchase price. */
  @Override
  public String calculaPreco(final FinalizaPedidoMessage message, Context context) {
    var valorFinal = message.getTotalPrice() * JUROS;
    message.setTotalPrice(valorFinal);

    return templateEngine.process("email/orderConfirmCard", context);
  }
}
