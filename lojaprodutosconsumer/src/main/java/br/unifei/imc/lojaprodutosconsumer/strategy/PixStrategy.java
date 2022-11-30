package br.unifei.imc.lojaprodutosconsumer.strategy;

import br.unifei.imc.lojaprodutosconsumer.messages.FinalizaPedidoMessage;
import br.unifei.imc.lojaprodutosconsumer.strategy.interfaces.PagamentoStrategy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.UUID;

@AllArgsConstructor
public class PixStrategy implements PagamentoStrategy {

  @Autowired private TemplateEngine templateEngine;

  private static final Double DESCONTO = 0.90;

  /** For PIX type payment, there will be a 10% discount on the total purchase price. */
  @Override
  public String calculaPreco(final FinalizaPedidoMessage message, Context context) {
    var valorFinal = message.getTotalPrice() * DESCONTO;
    message.setTotalPrice(valorFinal);
    message.setRandomKey(UUID.randomUUID().toString());

    return templateEngine.process("email/orderConfirmPix", context);
  }
}
