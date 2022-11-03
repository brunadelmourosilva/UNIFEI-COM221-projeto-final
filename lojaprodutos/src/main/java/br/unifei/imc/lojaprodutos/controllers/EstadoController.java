package br.unifei.imc.lojaprodutos.controllers;

import br.unifei.imc.lojaprodutos.dto.response.EstadoResponse;
import br.unifei.imc.lojaprodutos.services.EstadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Estado Controller")
public class EstadoController {

    private EstadoService estadoService;

    @GetMapping
    @Operation(summary = "Retorna todos os estados cadastrados")
    public ResponseEntity<List<EstadoResponse>> getAllStates() {
        var states = estadoService.getAllStates();

        return new ResponseEntity<>(states, HttpStatus.OK);
    }
}
