package br.unifei.imc.lojaprodutos.builders;

import br.unifei.imc.lojaprodutos.models.Cidade;
import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.models.Endereco;

public class EnderecoBuilder {

  private String street;

  private String number;

  private String complement;

  private String neighborhood;

  private String zipCode;

  private Cliente customer;

  private Cidade city;

  public static EnderecoBuilder builder() {
    return new EnderecoBuilder();
  }

  public EnderecoBuilder street(String street) {
    this.street = street;
    return this;
  }

  public EnderecoBuilder number(String number) {
    this.number = number;
    return this;
  }

  public EnderecoBuilder neighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
    return this;
  }

  public EnderecoBuilder zipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  public EnderecoBuilder complement(String complement) {
    this.complement = complement;
    return this;
  }

  public EnderecoBuilder customer(Cliente customer) {
    this.customer = customer;
    return this;
  }

  public EnderecoBuilder city(Cidade city) {
    this.city = city;
    return this;
  }

  public Endereco build() {
    return new Endereco(street, number, complement, neighborhood, zipCode, customer, city);
  }
}
