package br.unifei.imc.lojaprodutosconsumer.strategy.interfaces;

import br.unifei.imc.lojaprodutosconsumer.messages.FinalizaPedidoMessage;

public interface PagamentoStrategy {

    Double calculaPreco(FinalizaPedidoMessage message);
}
