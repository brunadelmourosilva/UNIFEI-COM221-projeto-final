package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.builders.EstadoBuilder;
import br.unifei.imc.lojaprodutos.models.Estado;

import java.util.List;

public class EstadoFactory {

  public static List<Estado> createEstados() {

    return List.of(
        EstadoBuilder.builder().name("São Paulo").build(),
        EstadoBuilder.builder().name("Minas Gerais").build(),
        EstadoBuilder.builder().name("Rio de Janeiro").build());
  }
}
