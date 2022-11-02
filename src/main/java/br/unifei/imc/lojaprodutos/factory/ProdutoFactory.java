package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.models.Categoria;
import br.unifei.imc.lojaprodutos.models.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoFactory {

    public static List<Produto> createProdutos(List<Categoria> categorias){

        String bucketBaseUrlProd = "https://bucket-unifei-trabalho-final.s3.amazonaws.com/prod";

        Categoria informatica = categorias.get(0);
        Categoria eletronicos = categorias.get(1);
        Categoria decoracao = categorias.get(2);
        Categoria jardinagem = categorias.get(3);
        Categoria mobilia = categorias.get(4);
        Categoria camaMesaBanho = categorias.get(5);

        List<Produto> produtos = new ArrayList<>();

        produtos.addAll(
          List.of(
                  Produto.builder().name("Celular Xiaomi Mi 10 Lite").categories(List.of(informatica, eletronicos)).price(2500d).image(bucketBaseUrlProd + "1.jpg").build(),
                  Produto.builder().name("Celular iPhone 13 Pro Max").categories(List.of(informatica, eletronicos)).price(8000d).image(bucketBaseUrlProd + "2.jpg").build(),
                  Produto.builder().name("Mouse Multilaser Pro 10").categories(List.of(informatica, eletronicos)).price(50d).image(bucketBaseUrlProd + "3.jpg").build(),
                  Produto.builder().name("Teclado Razer BlackWidow V3").categories(List.of(informatica, eletronicos)).price(500d).image(bucketBaseUrlProd + "4.jpg").build(),
                  Produto.builder().name("Sofá CasaBoa 3 Lugares").categories(List.of(mobilia)).price(3000d).image(bucketBaseUrlProd + "5.jpg").build(),
                  Produto.builder().name("Travesseiro Ortobom Espuma Macia").categories(List.of(camaMesaBanho)).price(200d).image(bucketBaseUrlProd + "6.jpg").build(),
                  Produto.builder().name("Abajur TopLuzes 300 Lumens").categories(List.of(mobilia, decoracao)).price(65d).image(bucketBaseUrlProd + "7.jpg").build(),
                  Produto.builder().name("Kit de Jardinagem Floris").categories(List.of(jardinagem)).price(1100d).image(bucketBaseUrlProd + "8.jpg").build(),
                  Produto.builder().name("Bota Emborrachada MaxJardim").categories(List.of(jardinagem)).price(50d).image(bucketBaseUrlProd + "9.jpg").build(),
                  Produto.builder().name("Vaso Suspenso Floris").categories(List.of(jardinagem, decoracao)).price(200d).image(bucketBaseUrlProd + "10.jpg").build(),
                  Produto.builder().name("Televisão 55 Polegadas LG").categories(List.of(eletronicos)).price(4000d).image(bucketBaseUrlProd + "11.jpg").build(),
                  Produto.builder().name("Macbook Air 13 Apple").categories(List.of(informatica, eletronicos)).price(8000d).image(bucketBaseUrlProd + "12.jpg").build(),
                  Produto.builder().name("Lustre Prateado Shine").categories(List.of(decoracao)).price(5000d).image(bucketBaseUrlProd + "13.jpg").build(),
                  Produto.builder().name("Banqueta Giratória Confort").categories(List.of(mobilia)).price(100d).image(bucketBaseUrlProd + "14.jpg").build()
          )
        );

        return produtos;
    }
}
