

TODO

todo: salvar cliente e depois usar o id do mesmo para salvar a lista de endereços, pois endereço tem ref. de cliente

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
