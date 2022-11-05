package br.unifei.imc.lojaprodutos.controllers;

import br.unifei.imc.lojaprodutos.dto.request.ClienteCadastroRequest;
import br.unifei.imc.lojaprodutos.dto.request.ClienteRequest;
import br.unifei.imc.lojaprodutos.dto.response.ClienteResponse;
import br.unifei.imc.lojaprodutos.dto.response.EnderecoResponse;
import br.unifei.imc.lojaprodutos.dto.response.PedidoResponse;
import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.models.Endereco;
import br.unifei.imc.lojaprodutos.models.Produto;
import br.unifei.imc.lojaprodutos.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Cliente Controller")
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping(value = "/pedidos/{clienteId}")
    @Operation(summary = "Retorna todos os pedidos de um cliente")
    public ResponseEntity<List<PedidoResponse>> findAllPedidos(@PathVariable Integer clienteId) {
        var pedidos = clienteService.findAllPedidosByClienteId(clienteId);

        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping(value = "/enderecos/{clienteId}")
    @Operation(summary = "Retorna todos os endereços de um cliente")
    public ResponseEntity<List<EnderecoResponse>> getAllAddresses(@PathVariable Integer clienteId) {
        var enderecos = clienteService.getAllAddressesByCustomer(clienteId);

        return new ResponseEntity<>(enderecos, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Realiza o cadastro de um cliente")
    @Transactional
    public ResponseEntity<ClienteResponse> insertCustomer(@RequestBody ClienteCadastroRequest clienteCadastroRequest) {
        var clienteResponse = clienteService.insertCustomer(clienteCadastroRequest);

        return new ResponseEntity<>(clienteResponse, HttpStatus.CREATED);
    }

}
