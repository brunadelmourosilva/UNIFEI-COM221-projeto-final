package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.models.Categoria;

import java.util.List;

public class CategoriaFactory {

    public static List<Categoria> createCategorias(){

        String bucketBaseUrlCat = "https://bucket-unifei-trabalho-final.s3.amazonaws.com/cat";

        return List.of(
                Categoria.builder().nome("Informática").imageUrl(bucketBaseUrlCat + "1.jpg").build(),
                Categoria.builder().nome("Eletrônicos").imageUrl(bucketBaseUrlCat + "2.jpg").build(),
                Categoria.builder().nome("Decoração").imageUrl(bucketBaseUrlCat + "3.jpg").build(),
                Categoria.builder().nome("Jardinagem").imageUrl(bucketBaseUrlCat + "4.jpg").build(),
                Categoria.builder().nome("Mobília").imageUrl(bucketBaseUrlCat + "5.jpg").build(),
                Categoria.builder().nome("Cama, Mesa e Banho").imageUrl(bucketBaseUrlCat + "6.jpg").build()
        );
    }
}
