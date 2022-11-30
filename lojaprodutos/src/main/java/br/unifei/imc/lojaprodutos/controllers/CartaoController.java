package br.unifei.imc.lojaprodutos.controllers;

import br.unifei.imc.lojaprodutos.dto.request.CartaoRequest;
import br.unifei.imc.lojaprodutos.dto.response.CartaoResponse;
import br.unifei.imc.lojaprodutos.dto.response.EstadoResponse;
import br.unifei.imc.lojaprodutos.services.CartaoService;
import br.unifei.imc.lojaprodutos.services.EstadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Cartão Controller")
public class CartaoController {

  private CartaoService cartaoService;

  @PostMapping
  @Operation(summary = "Realiza o cadastro do cartão do cliente")
  public ResponseEntity<CartaoResponse> insertCard(@RequestBody CartaoRequest cartaoRequest) {
    var cartaoResponse = cartaoService.insertCard(cartaoRequest);

    return new ResponseEntity<>(cartaoResponse, HttpStatus.CREATED);
  }

  @GetMapping(value = "/{clienteId}")
  @Operation(summary = "Retorna o cartão de um cliente")
  public ResponseEntity<CartaoResponse> findCardByCustomer(
      @PathVariable(name = "clienteId") Integer id) {
    var cartaoResponse = cartaoService.getCardByCustomer(id);

    return new ResponseEntity<>(cartaoResponse, HttpStatus.CREATED);
  }
}
