package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.models.Cliente;

public class ClienteFactory {

    public static Cliente createCliente(){
        return Cliente.builder().name("Marcelo Leite").email("marcelo@gmail.com").build();
    }
}