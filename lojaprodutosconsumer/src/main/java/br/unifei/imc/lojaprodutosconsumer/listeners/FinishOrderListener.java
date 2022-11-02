package br.unifei.imc.lojaprodutosconsumer.listeners;

import br.unifei.imc.lojaprodutosconsumer.messages.FinishOrderMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FinishOrderListener {

    private ObjectMapper objectMapper;

    public FinishOrderListener(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "#{'${spring.rabbitmq.queues}'.split(',')}")
    public void receiveMessage(Message message) throws IOException {
        final var result = objectMapper.readValue(message.getBody(), FinishOrderMessage.class);

        System.out.println(result.toString() + "\n\n\n");
    }
}
