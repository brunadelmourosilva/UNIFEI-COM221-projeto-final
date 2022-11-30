package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.builders.ClienteBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.unifei.imc.lojaprodutos.models.Cliente;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClienteFactory {

  private PasswordEncoder passwordEncoder;

  public Cliente createCliente() {

    return ClienteBuilder.builder()
        .name("Marcelo Leite")
        .email("marcelo@gmail.com")
        .password(passwordEncoder.encode("123"))
        .build();
  }
}
