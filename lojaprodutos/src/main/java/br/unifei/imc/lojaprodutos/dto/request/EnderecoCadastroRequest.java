package br.unifei.imc.lojaprodutos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoCadastroRequest {

  private String street;

  private String number;

  private String complement;

  private String neighborhood;

  private String zipCode;

  private CidadeRequest city;
}
