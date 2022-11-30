package br.unifei.imc.lojaprodutos.builders;

import br.unifei.imc.lojaprodutos.models.Cidade;
import br.unifei.imc.lojaprodutos.models.Estado;

public class CidadeBuilder {

  private String name;

  private Estado state;

  public static CidadeBuilder builder() {
    return new CidadeBuilder();
  }

  public CidadeBuilder name(String name) {
    this.name = name;
    return this;
  }

  public CidadeBuilder state(Estado state) {
    this.state = state;
    return this;
  }

  public Cidade build() {
    return new Cidade(name, state);
  }
}
