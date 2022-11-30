package br.unifei.imc.lojaprodutos.dto.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalizaPedidoRequest {

  private Integer payment;

  private EnderecoRequest address;

  private List<ProdutoRequest> products;

  private Double totalPrice;
}
