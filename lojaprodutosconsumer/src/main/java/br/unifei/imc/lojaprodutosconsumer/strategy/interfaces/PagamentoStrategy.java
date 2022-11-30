package br.unifei.imc.lojaprodutosconsumer.strategy.interfaces;

import br.unifei.imc.lojaprodutosconsumer.messages.FinalizaPedidoMessage;
import org.thymeleaf.context.Context;

public interface PagamentoStrategy {

  String calculaPreco(FinalizaPedidoMessage message, Context context);
}
