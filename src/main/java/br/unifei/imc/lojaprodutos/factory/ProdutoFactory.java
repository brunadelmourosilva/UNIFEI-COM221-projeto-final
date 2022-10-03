package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.models.Categoria;
import br.unifei.imc.lojaprodutos.models.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoFactory {

    public static List<Produto> createProdutos(List<Categoria> categorias){

        Categoria informatica = categorias.get(0);
        Categoria eletronicos = categorias.get(1);
        Categoria decoracao = categorias.get(2);
        Categoria jardinagem = categorias.get(3);
        Categoria mobilia = categorias.get(4);
        Categoria camaMesaBanho = categorias.get(5);

        List<Produto> produtos = new ArrayList<>();

        produtos.addAll(
          List.of(
                  Produto.builder().nome("Celular Xiaomi Mi 10 Lite").categorias(List.of(informatica, eletronicos)).preco(2500d).estoque(100).imageUrl("-").build(),
                  Produto.builder().nome("Celular iPhone 13 Pro Max").categorias(List.of(informatica, eletronicos)).preco(8000d).estoque(15).imageUrl("-").build(),
                  Produto.builder().nome("Mouse Multilaser Pro 10").categorias(List.of(informatica, eletronicos)).preco(50d).estoque(2000).imageUrl("-").build(),
                  Produto.builder().nome("Teclado Razer BlackWidow V3").categorias(List.of(informatica, eletronicos)).preco(500d).estoque(40).imageUrl("-").build(),
                  Produto.builder().nome("Sofá CasaBoa 3 Lugares").categorias(List.of(mobilia)).preco(3000d).estoque(70).imageUrl("-").build(),
                  Produto.builder().nome("Travesseiro Ortobom Espuma Macia").categorias(List.of(camaMesaBanho)).preco(200d).estoque(1000).imageUrl("-").build(),
                  Produto.builder().nome("Abajur TopLuzes 300 Lumens").categorias(List.of(mobilia, decoracao)).preco(65d).estoque(120).imageUrl("-").build(),
                  Produto.builder().nome("Kit de Jardinagem Floris").categorias(List.of(jardinagem)).preco(1100d).estoque(20).imageUrl("-").build(),
                  Produto.builder().nome("Bota Emborrachada MaxJardim").categorias(List.of(jardinagem)).preco(50d).estoque(100).imageUrl("-").build(),
                  Produto.builder().nome("Vaso Suspenso Floris").categorias(List.of(jardinagem, decoracao)).preco(200d).estoque(35).imageUrl("-").build(),
                  Produto.builder().nome("Televisão 55 Polegadas LG").categorias(List.of(eletronicos)).preco(4000d).estoque(10).imageUrl("-").build(),
                  Produto.builder().nome("Macbook Air 13 Apple").categorias(List.of(informatica, eletronicos)).preco(8000d).estoque(5).imageUrl("-").build(),
                  Produto.builder().nome("Lustre Prateado Shine").categorias(List.of(decoracao)).preco(5000d).estoque(10).imageUrl("-").build(),
                  Produto.builder().nome("Banqueta Giratória Confort").categorias(List.of(mobilia)).preco(100d).estoque(300).imageUrl("-").build()
          )
        );

        return produtos;
    }

}
