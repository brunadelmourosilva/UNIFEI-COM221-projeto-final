package br.unifei.imc.lojaprodutos.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unifei.imc.lojaprodutos.dto.response.PedidoResponse;
import br.unifei.imc.lojaprodutos.models.FinalizaPedido;
import br.unifei.imc.lojaprodutos.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Pedido Controller")
public class PedidoController {

    private ClienteService clienteService;
    private PedidoService pedidoService;

    @GetMapping(value = "/pedidos/cliente/{id}")
    @Operation(summary = "Retorna todos os pedidos de um cliente")
    public ResponseEntity<List<PedidoResponse>> findAllPedidos(@PathVariable Integer id) {
        var pedidos = clienteService.findAllPedidosByClienteId(id);

        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping(value = "/pedidos/finaliza")
    @Operation(summary = "Finaliza um pedido")
    public String finalizaPedido(@RequestBody FinalizaPedido finalizaPedido){

        return "Esse endpoint ainda não está finalizado, mas vc pode seguir o exemplo do body para mapear no front";
    }

}
