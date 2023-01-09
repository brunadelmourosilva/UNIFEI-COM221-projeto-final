
#  Trabalho final - computação orientada à objetos II

## E-commerce

API desenvolvida para a disciplina COM221, cujo objetivo é realizar a compra de produtos diversos, por meio de um sistema integrado entre front-end e back-end.
Em suma, o back-end da aplicação consiste de dois microservices, com as seguintes responsabilidades:

- microservice lojaprodutos: responsável por realizar toda a lógica da aplicação, constituindo-se de endpoints para o recebimento das informações, realização de regras de negócio, comunicação com a camada de persistência de dados e envio de mensagens para a fila do RabbitMQ. Dessa forma, o mesmo tem a responsabilidade de realizar o cadastro de usuários e pedidos, além de recuperar informações para enviar ao front-end.

- microservice lojaprodutosconsumer: responsável por receber os dados referentes à finalização do pedido feito pelo usuário, através do microservice **lojaprodutos**.
Dessa forma, o microservice realizará o envio do e-mail contendo as informações do pedido, bem como o método de pagamento escolhido. Vale ressaltar que, a comunicação entre os dois microservices é realizada de maneira assíncrona, utilizando a ferramenta RabbitMQ como gerenciador das mensagens enviadas e recebidas. 

Por fim e não menos importante, a aplicação como um todo, incluindo back-end e front-end, encontra-se conteinerizada com a ferramenta Docker e hospedada pela máquina virtual Amazon EC2.

---

### Status
>Concluído ✔️

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
* Amazon S3

---

### Design patterns utilizados 📚

### Strategy
> Design pattern aplicado para o gerenciamento dos templates(criados com a biblioteca Thymeleaf) destinados ao e-mail, quando for escolhidor um dos métodos de pagamento, sendo eles, PIX ou cartão de crédito.

### Builder
> Design pattern aplicado para a construção de objetos, de maneira mais flexível e menos verbosa.

### DTO(Data Transfer Object)
> Design pattern aplicado tanto para receber dados do front-end, quanto para enviá-los a partir do back-end. Em suma, seriam classes que provêm exatamente aquilo que é necessário para um determinado processo. 

---

### Apresentação do sistema: 

[![Watch the video](https://github.com/brunadelmourosilva/UNIFEI-COM221-projeto-final/blob/master/Thumbnail.PNG?raw=true)](https://www.youtube.com/watch?v=HuqV5qcEEAs)
