package br.unifei.imc.lojaprodutos.controllers;

import br.unifei.imc.lojaprodutos.dto.response.EnderecoResponse;
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

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Cliente Controller")
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping(value = "/enderecos/{id}")
    @Operation(summary = "Retorna todos os endereços de um cliente")
    public ResponseEntity<List<EnderecoResponse>> getAllAddresses(@PathVariable Integer id) {
        var enderecos = clienteService.getAllAddressesByCustomer(id);

        return new ResponseEntity<>(enderecos, HttpStatus.OK);
    }
}
