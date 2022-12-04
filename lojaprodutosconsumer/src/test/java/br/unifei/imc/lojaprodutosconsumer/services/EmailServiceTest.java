package br.unifei.imc.lojaprodutosconsumer.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.util.ReflectionTestUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import br.unifei.imc.lojaprodutosconsumer.messages.FinalizaPedidoMessage;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

  @InjectMocks private EmailServiceImpl emailService;

  @Mock private TemplateEngine templateEngine;

  @Mock private JavaMailSender javaMailSender;

  private FinalizaPedidoMessage finalizaPedidoMessage;

  private MimeMessage mimeMessage;

  private static final String DEFAULT_SENDER = "bruna@gmail.com";

  @BeforeEach
  void setup() throws MessagingException {
    PodamFactory factory = new PodamFactoryImpl();
    finalizaPedidoMessage = factory.manufacturePojo(FinalizaPedidoMessage.class);
    finalizaPedidoMessage.setPayment(1);

    mimeMessage = new MimeMessage((Session) null);

    ReflectionTestUtils.setField(emailService, "sender", DEFAULT_SENDER);
  }

  // @Test
  // void sendEmail_DeveEnviarEmailComSucesso_QuandoEmailExiste(){
  //     BDDMockito.given(javaMailSender.createMimeMessage()).willReturn(mimeMessage);

  //     BDDMockito.given(templateEngine.process(eq("/email"), any(Context.class)))
  // .willReturn("a template");

  //     emailService.sendEmail(finalizaPedidoMessage);
  // }
}
