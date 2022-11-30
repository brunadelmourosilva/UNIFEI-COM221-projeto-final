package br.unifei.imc.lojaprodutos.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalizaPedidoResponse {

  private String email;

  private Integer payment;

  private EnderecoResponse address;

  private List<ProdutoResponse> products;

  private Double totalPrice;
}
