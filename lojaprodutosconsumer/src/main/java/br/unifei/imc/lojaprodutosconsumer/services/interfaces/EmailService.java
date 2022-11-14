package br.unifei.imc.lojaprodutosconsumer.services.interfaces;

import br.unifei.imc.lojaprodutosconsumer.messages.FinalizaPedidoMessage;
import br.unifei.imc.lojaprodutosconsumer.strategy.interfaces.PagamentoStrategy;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public interface EmailService {

    void sendEmail(FinalizaPedidoMessage message);

    MimeMessage prepareSimpleMailMessageFromFinishOrder(FinalizaPedidoMessage message) throws MessagingException;

    String htmlFromTemplateOrder(FinalizaPedidoMessage message, PagamentoStrategy pagamentoStrategy);
}
