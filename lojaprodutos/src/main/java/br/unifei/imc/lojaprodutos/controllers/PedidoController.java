package br.unifei.imc.lojaprodutos.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unifei.imc.lojaprodutos.dto.request.FinalizaPedidoRequest;
import br.unifei.imc.lojaprodutos.services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Pedido Controller")
public class PedidoController {

  private PedidoService pedidoService;

  @PostMapping(value = "/finaliza-pedido")
  @Operation(summary = "Finaliza um pedido do cliente")
  public String finalizaPedido(@RequestBody FinalizaPedidoRequest finalizaPedidoRequest) {

    return pedidoService.insertOrder(finalizaPedidoRequest);
  }
}
