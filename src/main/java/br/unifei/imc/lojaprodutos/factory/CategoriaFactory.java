package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.models.Categoria;

import java.util.List;

public class CategoriaFactory {

    public static List<Categoria> createCategorias(){
        return List.of(
                Categoria.builder().nome("Informática").imageUrl("-").build(),
                Categoria.builder().nome("Eletrônicos").imageUrl("-").build(),
                Categoria.builder().nome("Decoração").imageUrl("-").build(),
                Categoria.builder().nome("Jardinagem").imageUrl("-").build(),
                Categoria.builder().nome("Mobília").imageUrl("-").build(),
                Categoria.builder().nome("Cama, Mesa e Banho").imageUrl("-").build()
        );
    }
}
