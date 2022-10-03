package br.unifei.imc.lojaprodutos.controllers;

import br.unifei.imc.lojaprodutos.models.Endereco;
import br.unifei.imc.lojaprodutos.models.Produto;
import br.unifei.imc.lojaprodutos.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping(value = "/enderecos/{id}")
    public ResponseEntity<List<Endereco>> getAllAddresses(@PathVariable Integer id) {
        var enderecos = clienteService.getAllAddressesByCustomer(id);

        return new ResponseEntity<>(enderecos, HttpStatus.OK);
    }
}
