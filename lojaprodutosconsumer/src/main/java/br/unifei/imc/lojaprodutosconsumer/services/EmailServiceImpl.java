package br.unifei.imc.lojaprodutosconsumer.services;

import br.unifei.imc.lojaprodutosconsumer.messages.FinalizaPedidoMessage;
import br.unifei.imc.lojaprodutosconsumer.services.interfaces.EmailService;
import br.unifei.imc.lojaprodutosconsumer.strategy.CartaoStrategy;
import br.unifei.imc.lojaprodutosconsumer.strategy.PixStrategy;
import br.unifei.imc.lojaprodutosconsumer.strategy.interfaces.PagamentoStrategy;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.Instant;
import java.util.Date;

@Service
@Log4j2
public class EmailServiceImpl implements EmailService {

  @Value("${default.sender}")
  private String sender;

  @Autowired private JavaMailSender javaMailSender;

  @Autowired private TemplateEngine templateEngine;

  private PagamentoStrategy pagamento;

  @Override
  public void sendEmail(FinalizaPedidoMessage message) {
    if (StringUtils.isNotBlank(message.getCustomer().getEmail())) {
      MimeMessage sendMessage = null;

      try {
        sendMessage = prepareSimpleMailMessageFromFinishOrder(message);
        javaMailSender.send(sendMessage);
        log.info("E-mail sent to " + message.getCustomer().getEmail());
      } catch (MessagingException e) {
        throw new RuntimeException(e);
      }
    }
  }

  @Override
  public MimeMessage prepareSimpleMailMessageFromFinishOrder(FinalizaPedidoMessage message)
      throws MessagingException {
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

    messageHelper.setFrom(sender);
    messageHelper.setTo(message.getCustomer().getEmail());

    messageHelper.setSubject("Order confirmed!");
    messageHelper.setSentDate(Date.from(Instant.now()));
    messageHelper.setText(htmlFromTemplateOrder(message, this.pagamento), true);

    return mimeMessage;
  }

  @Override
  public String htmlFromTemplateOrder(
      FinalizaPedidoMessage message, PagamentoStrategy pagamentoStrategy) {
    Context context = new Context();
    context.setVariable("message", message); // nickname for thymeleaf

    this.pagamento =
        message.getPayment().equals(1)
            ? new PixStrategy(templateEngine)
            : new CartaoStrategy(templateEngine);

    return this.pagamento.calculaPreco(message, context);
  }
}
