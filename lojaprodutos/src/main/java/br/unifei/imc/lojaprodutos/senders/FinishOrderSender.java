package br.unifei.imc.lojaprodutos.senders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FinishOrderSender {

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    private AmqpTemplate amqpTemplate;

    private ObjectMapper objectMapper;

    public FinishOrderSender(final AmqpTemplate amqpTemplate, final ObjectMapper objectMapper) {
        this.amqpTemplate = amqpTemplate;
        this.objectMapper = objectMapper;
    }

    public void publishMessage(String objetoOrder) throws JsonProcessingException {
        var message = convertObjectToJson(objetoOrder);

        amqpTemplate.convertAndSend(exchange, "", message);

        //todo add logs depois que mensagem for postada
        //todo exchange error
    }

    private String convertObjectToJson(String objetoOrder) throws JsonProcessingException {
        return objectMapper.writeValueAsString(objetoOrder);
    }

}
