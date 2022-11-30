
Status

:warning: Em progresso

---

TODO

README + techs

todo: tratar as exceptions para finalizar pedido

todo patterns: builder, strategy, DTO... OK


producer

* OK definir objeto
* OK implementar endpoint para pedido finalizado
* OK implementar service e fazer chamada para o sender do rabbitMQ
* implementar erro para envio no dead-letter  

consumer

* OK receber objeto order
* OK implementar strategy com formas de pagamento escolhida
* OK realizar calculos -> implementar calculo preço total back-end
* OK enviar email para cliente
* OK implementar tymeleaf para template do e-mail


* testes unitários e integração
* fazer UML do sistema
