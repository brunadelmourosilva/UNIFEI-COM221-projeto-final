package br.unifei.imc.lojaprodutos.senders.messages;

import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.models.Endereco;
import br.unifei.imc.lojaprodutos.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalizaPedidoMessage {

  private Integer id;

  private Date date;

  private ClienteMessage customer;

  private List<ProdutoMessage> products;

  private EnderecoMessage address;

  private Double totalPrice;

  private Integer payment;
}
