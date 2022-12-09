 package br.unifei.imc.lojaprodutos.config;

 import org.springframework.amqp.core.AmqpAdmin;
 import org.springframework.amqp.core.BindingBuilder;
 import org.springframework.amqp.core.FanoutExchange;
 import org.springframework.amqp.core.Queue;
 import org.springframework.amqp.rabbit.annotation.EnableRabbit;
 import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
 import org.springframework.amqp.rabbit.connection.ConnectionFactory;
 import org.springframework.amqp.rabbit.core.RabbitAdmin;
 import org.springframework.beans.factory.annotation.Value;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;

 @EnableRabbit
 @Configuration
 public class RabbitMQConfig {

   @Value("${spring.rabbitmq.host}")
   private String host;

   @Value("${spring.rabbitmq.username}")
   private String username;

   @Value("${spring.rabbitmq.password}")
   private String password;

   @Value("#{'${spring.rabbitmq.queues}'.split(',')}")
   private String[] queues;

   @Value("${spring.rabbitmq.exchange}")
   private String exchange;

   @Bean
   public AmqpAdmin amqpAdmin() {
     AmqpAdmin declare = new RabbitAdmin(connectionFactory());

     /* declare exchange */
     declare.declareExchange(exchange());

     /* declare queues and declare bindings */
     for (int i = 0; i < queues.length; i++) {
       var queue = new Queue(queues[i], true);

       declare.declareQueue(queue);

       declare.declareBinding(BindingBuilder.bind(queue).to(exchange()));
     }

     return declare;
   }

   @Bean
   FanoutExchange exchange() {
     return new FanoutExchange(exchange);
   }

   @Bean
   public ConnectionFactory connectionFactory() {
     CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
     connectionFactory.setHost(host);
     connectionFactory.setUsername(username);
     connectionFactory.setPassword(password);

     return connectionFactory;
   }
 }
