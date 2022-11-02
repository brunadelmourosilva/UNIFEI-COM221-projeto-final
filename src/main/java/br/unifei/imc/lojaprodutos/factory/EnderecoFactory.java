package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.models.Cidade;
import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.models.Endereco;

import java.util.List;

public class EnderecoFactory {

    public static List<Endereco> createEnderecos(Cliente cliente, Cidade cidade){

        return List.of(
                Endereco.builder().zipCode("37500208").street("Rua das Flores").neighborhood("Centro").customer(cliente).number("387").complement("Casa").city(cidade).build(),
                Endereco.builder().zipCode("28030948").street("Rua Jardins").neighborhood("Centro").customer(cliente).number("213").complement("Apartamento").city(cidade).build()
        );
    }
}
