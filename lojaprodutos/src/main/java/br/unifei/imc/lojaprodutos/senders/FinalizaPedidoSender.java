package br.unifei.imc.lojaprodutos.senders;

import br.unifei.imc.lojaprodutos.dto.request.FinalizaPedidoRequest;
import br.unifei.imc.lojaprodutos.senders.messages.FinalizaPedidoMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class FinalizaPedidoSender {

  @Value("${spring.rabbitmq.exchange}")
  private String exchange;

  private AmqpTemplate amqpTemplate;

  private ObjectMapper objectMapper;

  public FinalizaPedidoSender(final AmqpTemplate amqpTemplate, final ObjectMapper objectMapper) {
    this.amqpTemplate = amqpTemplate;
    this.objectMapper = objectMapper;
  }

  public void publishMessage(FinalizaPedidoMessage finalizaPedidoMessage) {

    String message = StringUtils.EMPTY;
    try {
      message = convertObjectToJson(finalizaPedidoMessage);

      amqpTemplate.convertAndSend(exchange, "", message);

      log.info("The message was posted in the queue with success!");
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
      //todo exchange error
    }
  }

  private String convertObjectToJson(FinalizaPedidoMessage finalizaPedidoMessage)
      throws JsonProcessingException {
    return objectMapper.writeValueAsString(finalizaPedidoMessage);
  }
}
