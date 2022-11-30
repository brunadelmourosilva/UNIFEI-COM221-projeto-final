package br.unifei.imc.lojaprodutos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteCadastroRequest {

  private String name;

  private String email;

  private String password;

  private List<EnderecoCadastroRequest> addresses;
}
