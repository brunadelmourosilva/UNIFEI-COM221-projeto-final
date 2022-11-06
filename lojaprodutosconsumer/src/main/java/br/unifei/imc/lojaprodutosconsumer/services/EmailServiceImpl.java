package br.unifei.imc.lojaprodutosconsumer.services;

import br.unifei.imc.lojaprodutosconsumer.messages.FinalizaPedidoMessage;
import br.unifei.imc.lojaprodutosconsumer.services.interfaces.EmailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmailServiceImpl implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendEmail(FinalizaPedidoMessage message){
        SimpleMailMessage sendMessage = prepareSimpleMailMessageFromFinishOrder(message);
        mailSender.send(sendMessage);

        log.info("E-mail sent!");
    }

    @Override
    public SimpleMailMessage prepareSimpleMailMessageFromFinishOrder(FinalizaPedidoMessage message) {
        var simpleMailMessage =new SimpleMailMessage();

        simpleMailMessage.setFrom(sender);

        simpleMailMessage.setTo();

        simpleMailMessage.setSubject("Dummy subject");

        simpleMailMessage.setText("Hello, " + message.getCustomer().getName() + "! ");

        return simpleMailMessage;
    }
}
