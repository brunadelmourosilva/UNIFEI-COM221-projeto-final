package br.unifei.imc.lojaprodutosconsumer.strategy;

import br.unifei.imc.lojaprodutosconsumer.messages.FinalizaPedidoMessage;
import br.unifei.imc.lojaprodutosconsumer.strategy.interfaces.PagamentoStrategy;

public class PixStrategy implements PagamentoStrategy {

    private static final Double DISCONTO = 0.90;

    /**
     * For PIX type payment, there will be a 10% discount on the total purchase price.
     * */

    @Override
    public Double calculaPreco(final FinalizaPedidoMessage message) {
        return message.getValorTotal() * DISCONTO;
    }
}
