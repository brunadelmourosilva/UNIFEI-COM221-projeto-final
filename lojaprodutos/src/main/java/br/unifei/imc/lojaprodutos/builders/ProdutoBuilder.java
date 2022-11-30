package br.unifei.imc.lojaprodutos.builders;

import br.unifei.imc.lojaprodutos.models.Categoria;
import br.unifei.imc.lojaprodutos.models.Produto;

import java.util.List;

public class ProdutoBuilder {

  private String name;

  private Double price;

  private String image;

  private List<Categoria> categories;

  public static ProdutoBuilder builder() {
    return new ProdutoBuilder();
  }

  public ProdutoBuilder name(String name) {
    this.name = name;
    return this;
  }

  public ProdutoBuilder price(Double price) {
    this.price = price;
    return this;
  }

  public ProdutoBuilder image(String image) {
    this.image = image;
    return this;
  }

  public ProdutoBuilder categories(List<Categoria> categories) {
    this.categories = categories;
    return this;
  }

  public Produto build() {
    return new Produto(name, price, image, categories);
  }
}
