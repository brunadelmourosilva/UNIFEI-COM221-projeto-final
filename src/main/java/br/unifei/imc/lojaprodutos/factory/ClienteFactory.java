package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.models.Cidade;
import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.models.Endereco;
import br.unifei.imc.lojaprodutos.models.Estado;

import java.util.List;

public class ClienteFactory {

    public static Cliente createCliente(){
        return Cliente.builder().nome("Marcelo Leite").cpf("2135467689").email("marcelo@gmail.com").build();
    }
}
