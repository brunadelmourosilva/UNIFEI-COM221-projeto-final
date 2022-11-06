

TODO
todo: tratar todas as exceptions e add exception personalizada

todo: converter classes para inglês

todo: adicionar ENUM para payment(1 ou 2)

todo: validar se user já existe pelo e-mail

todo: realizar calculo do preço total no back-end(producer/consumer)

producer

* OK definir objeto
* OK implementar endpoint para pedido finalizado
* OK implementar service e fazer chamada para o sender do rabbitMQ
* implementar erro para envio no dead-letter  

consumer

* OK receber objeto order
* OK implementar strategy com formas de pagamento escolhida
* realizar calculos -> implementar calculo preço total back-end
* OK enviar email para cliente
* implementar tymeleaf para template do e-mail


* testes unitários e integração
* fazer UML do sistema
