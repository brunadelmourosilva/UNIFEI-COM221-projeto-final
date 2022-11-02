package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.models.Estado;

import java.util.List;

public class EstadoFactory {

    public static List<Estado> createEstados(){

        return List.of(
                Estado.builder().name("São Paulo").build(),
                Estado.builder().name("Minas Gerais").build(),
                Estado.builder().name("Rio de Janeiro").build()
        );
    }
}
