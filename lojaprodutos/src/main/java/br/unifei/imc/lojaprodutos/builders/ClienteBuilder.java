package br.unifei.imc.lojaprodutos.builders;

import br.unifei.imc.lojaprodutos.models.Cliente;

public class ClienteBuilder {

  private String name;

  private String email;

  private String password;

  public static ClienteBuilder builder() {
    return new ClienteBuilder();
  }

  public ClienteBuilder name(String name) {
    this.name = name;
    return this;
  }

  public ClienteBuilder email(String email) {
    this.email = email;
    return this;
  }

  public ClienteBuilder password(String password) {
    this.password = password;
    return this;
  }

  public Cliente build() {
    return new Cliente(name, email, password);
  }
}
