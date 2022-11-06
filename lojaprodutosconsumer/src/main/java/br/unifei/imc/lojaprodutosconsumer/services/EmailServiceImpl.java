package br.unifei.imc.lojaprodutosconsumer.services;

import br.unifei.imc.lojaprodutosconsumer.messages.FinalizaPedidoMessage;
import br.unifei.imc.lojaprodutosconsumer.services.interfaces.EmailService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@Log4j2
public class EmailServiceImpl implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendEmail(FinalizaPedidoMessage message){
        if(StringUtils.isNotBlank(message.getCustomer().getEmail())) {
            SimpleMailMessage sendMessage = prepareSimpleMailMessageFromFinishOrder(message);
            mailSender.send(sendMessage);

            log.info("E-mail sent to " + message.getCustomer().getEmail());
        }
    }


    //todo adicionar thymeleaf para corpo do e-mail
    //todo implementar strategy com formas de pagamento escolhida
    //todo se pix: enviar QR code(aprender como criar QR code)
    //todo se cartão: enviar dados do cartão de acordo com cliente
    @Override
    public SimpleMailMessage prepareSimpleMailMessageFromFinishOrder(FinalizaPedidoMessage message) {
        var simpleMailMessage =new SimpleMailMessage();

        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(message.getCustomer().getEmail());

        simpleMailMessage.setSubject("Dummy subject");
        simpleMailMessage.setText("Hello, " + message.getCustomer().getName() + "! ");
        simpleMailMessage.setSentDate(Date.from(Instant.now()));

        return simpleMailMessage;
    }
}
