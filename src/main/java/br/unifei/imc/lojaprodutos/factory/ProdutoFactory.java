package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.models.Categoria;
import br.unifei.imc.lojaprodutos.models.Produto;
import org.springframework.stereotype.Component;

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
                  Produto.builder().nome("Celular Xiaomi Mi 10 Lite").categorias(List.of(informatica, eletronicos)).preco(2500d).estoque(100).imageUrl(bucketBaseUrlProd + "1.jpg").build(),
                  Produto.builder().nome("Celular iPhone 13 Pro Max").categorias(List.of(informatica, eletronicos)).preco(8000d).estoque(15).imageUrl(bucketBaseUrlProd + "2.jpg").build(),
                  Produto.builder().nome("Mouse Multilaser Pro 10").categorias(List.of(informatica, eletronicos)).preco(50d).estoque(2000).imageUrl(bucketBaseUrlProd + "3.jpg").build(),
                  Produto.builder().nome("Teclado Razer BlackWidow V3").categorias(List.of(informatica, eletronicos)).preco(500d).estoque(40).imageUrl(bucketBaseUrlProd + "4.jpg").build(),
                  Produto.builder().nome("Sofá CasaBoa 3 Lugares").categorias(List.of(mobilia)).preco(3000d).estoque(70).imageUrl(bucketBaseUrlProd + "5.jpg").build(),
                  Produto.builder().nome("Travesseiro Ortobom Espuma Macia").categorias(List.of(camaMesaBanho)).preco(200d).estoque(1000).imageUrl(bucketBaseUrlProd + "6.jpg").build(),
                  Produto.builder().nome("Abajur TopLuzes 300 Lumens").categorias(List.of(mobilia, decoracao)).preco(65d).estoque(120).imageUrl(bucketBaseUrlProd + "7.jpg").build(),
                  Produto.builder().nome("Kit de Jardinagem Floris").categorias(List.of(jardinagem)).preco(1100d).estoque(20).imageUrl(bucketBaseUrlProd + "8.jpg").build(),
                  Produto.builder().nome("Bota Emborrachada MaxJardim").categorias(List.of(jardinagem)).preco(50d).estoque(100).imageUrl(bucketBaseUrlProd + "9.jpg").build(),
                  Produto.builder().nome("Vaso Suspenso Floris").categorias(List.of(jardinagem, decoracao)).preco(200d).estoque(35).imageUrl(bucketBaseUrlProd + "10.jpg").build(),
                  Produto.builder().nome("Televisão 55 Polegadas LG").categorias(List.of(eletronicos)).preco(4000d).estoque(10).imageUrl(bucketBaseUrlProd + "11.jpg").build(),
                  Produto.builder().nome("Macbook Air 13 Apple").categorias(List.of(informatica, eletronicos)).preco(8000d).estoque(5).imageUrl(bucketBaseUrlProd + "12.jpg").build(),
                  Produto.builder().nome("Lustre Prateado Shine").categorias(List.of(decoracao)).preco(5000d).estoque(10).imageUrl(bucketBaseUrlProd + "13.jpg").build(),
                  Produto.builder().nome("Banqueta Giratória Confort").categorias(List.of(mobilia)).preco(100d).estoque(300).imageUrl(bucketBaseUrlProd + "14.jpg").build()
          )
        );

        return produtos;
    }
}
