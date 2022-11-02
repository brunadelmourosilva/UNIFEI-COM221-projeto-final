package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.models.Categoria;

import java.util.List;

public class CategoriaFactory {

    public static List<Categoria> createCategorias(){

        String bucketBaseUrlCat = "https://bucket-unifei-trabalho-final.s3.amazonaws.com/cat";

        return List.of(
                Categoria.builder().name("Informática").image(bucketBaseUrlCat + "1.jpg").build(),
                Categoria.builder().name("Eletrônicos").image(bucketBaseUrlCat + "2.jpg").build(),
                Categoria.builder().name("Decoração").image(bucketBaseUrlCat + "3.jpg").build(),
                Categoria.builder().name("Jardinagem").image(bucketBaseUrlCat + "4.jpg").build(),
                Categoria.builder().name("Mobília").image(bucketBaseUrlCat + "5.jpg").build(),
                Categoria.builder().name("Cama, Mesa e Banho").image(bucketBaseUrlCat + "6.jpg").build()
        );
    }
}
