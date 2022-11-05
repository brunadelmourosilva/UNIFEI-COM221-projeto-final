

TODO
todo: tratar todas as exceptions e add exception personalizada
todo: converter classes para inglês
todo: adicionar ENUM para payment(1 ou 2)

producer

* definir objeto
* implementar endpoint para pedido finalizado
* implementar service e fazer chamada para o sender do rabbitMQ

consumer

* receber objeto order
* implementar strategy com formas de pagamento escolhida
* realizar calculos
* enviar email para cliente com o valor da compra e demais dados

testes unitários e integração
