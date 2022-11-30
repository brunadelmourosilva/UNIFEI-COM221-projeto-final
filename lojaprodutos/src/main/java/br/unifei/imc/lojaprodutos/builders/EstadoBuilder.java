package br.unifei.imc.lojaprodutos.builders;

import br.unifei.imc.lojaprodutos.models.Estado;

public class EstadoBuilder {

  private String name;

  public static EstadoBuilder builder() {
    return new EstadoBuilder();
  }

  public EstadoBuilder name(String name) {
    this.name = name;
    return this;
  }

  public Estado build() {
    return new Estado(name);
  }
}
