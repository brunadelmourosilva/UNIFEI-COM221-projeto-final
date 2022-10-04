package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.models.Cidade;
import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.models.Endereco;

import java.util.List;

public class EnderecoFactory {

    public static List<Endereco> createEnderecos(Cliente cliente, Cidade cidade){

        return List.of(
                Endereco.builder().cep("37500208").rua("Rua das Flores").bairro("Centro").cliente(cliente).numero("387").complemento("Casa").cidade(cidade).build(),
                Endereco.builder().cep("28030948").rua("Rua Jardins").bairro("Centro").cliente(cliente).numero("213").complemento("Apartamento").cidade(cidade).build()
        );
    }
}
