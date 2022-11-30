package br.unifei.imc.lojaprodutos.senders.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CidadeMessage {

  private String name;
  private EstadoMessage state;
}
