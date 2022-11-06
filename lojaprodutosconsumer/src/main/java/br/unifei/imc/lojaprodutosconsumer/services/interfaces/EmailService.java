package br.unifei.imc.lojaprodutosconsumer.services.interfaces;

import br.unifei.imc.lojaprodutosconsumer.messages.FinalizaPedidoMessage;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendEmail(FinalizaPedidoMessage message);

    SimpleMailMessage prepareSimpleMailMessageFromFinishOrder(FinalizaPedidoMessage message);
}
