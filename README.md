
#  Trabalho final - computação orientada à objetos II

## E-commerce

API desenvolvida para a disciplina COM221, cujo objetivo é realizar a compra de produtos diversos, por meio de um sistema integrado entre front-end e back-end.
Em suma, o back-end da aplicação consiste de dois microservices, com as seguintes responsabilidades:

- microservice lojaprodutos: ....

-microservice lojaprodutosconsumer: responsável por receber os dados referentes à finalização do pedido feito pelo usuário, através do microservice **lojaprodutos**.
Dessa forma, o microservice realizará o envio do e-mail contendo as informações do pedido, bem como o método de pagamento escolhido. Vale ressaltar que, a comunicação entre os dois microservices é realizada de maneira assíncrona, utilizando a ferramenta RabbitMQ como gerenciador das mensagens enviadas e recebidas. 

Por fim e não menos importante, a aplicação como um todo, incluindo back-end e front-end encontra-se conteinerizada com a ferramenta Docker e hospedada pela máquina virtual Amazon EC2.

---

### Status
>Concluído ✔️

>Apresentação: link

---

### Tecnologias 🖥️

* Java 11
* Spring Boot 2.7.4
* Spring Data JPA
* Spring Security e JWT
* Spring Validation
* Spring Mail

* Junit 5
* Mockito

* Maven
* Thymeleaf
* Google SMTP
* Lombok
* ModelMapper
* Swagger
* Coveo plugin

* H2 Database

* RabbitMQ
* Docker
* Amazon Elastic Compute Cloud(EC2)

---
