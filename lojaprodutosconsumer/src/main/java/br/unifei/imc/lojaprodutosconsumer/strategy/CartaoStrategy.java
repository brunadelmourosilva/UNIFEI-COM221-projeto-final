package br.unifei.imc.lojaprodutosconsumer.strategy;

import br.unifei.imc.lojaprodutosconsumer.messages.FinalizaPedidoMessage;
import br.unifei.imc.lojaprodutosconsumer.strategy.interfaces.PagamentoStrategy;

public class CartaoStrategy implements PagamentoStrategy {

    private static final Double JUROS = 1.02;

    /**
     * For CARD type payment, there will be a 0.02% extra on the total purchase price.
     * */

    @Override
    public Double calculaPreco(final FinalizaPedidoMessage message) {
        return message.getTotalPrice() * JUROS;
    }
}
