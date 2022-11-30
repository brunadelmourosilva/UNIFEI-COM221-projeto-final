package br.unifei.imc.lojaprodutos.senders.messages;

import br.unifei.imc.lojaprodutos.models.Cidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoMessage {

  private String street;

  private String number;

  private String complement;

  private String neighborhood;

  private String zipCode;

  private CidadeMessage city;
}
