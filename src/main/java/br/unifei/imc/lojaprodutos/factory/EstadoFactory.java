package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.models.Cidade;
import br.unifei.imc.lojaprodutos.models.Estado;

import java.util.List;

public class EstadoFactory {

    public static List<Estado> createEstados(){

        return List.of(
                Estado.builder().nome("São Paulo").build(),
                Estado.builder().nome("Minas Gerais").build(),
                Estado.builder().nome("Rio de Janeiro").build()
        );
    }
}
