package br.unifei.imc.lojaprodutosconsumer.listeners;

import br.unifei.imc.lojaprodutosconsumer.messages.FinalizaPedidoMessage;
import br.unifei.imc.lojaprodutosconsumer.services.interfaces.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@AllArgsConstructor
@Component
public class FinalizaPedidoListener {

    private ObjectMapper objectMapper;

    private EmailService emailService;


    @RabbitListener(queues = "#{'${spring.rabbitmq.queues}'.split(',')}")
    public void receiveMessage(Message message) throws IOException {
        final var result = objectMapper.readValue(message.getBody(), FinalizaPedidoMessage.class);

        emailService.sendEmail(result);
    }
}
