package br.unifei.imc.lojaprodutos.controllers;

import br.unifei.imc.lojaprodutos.dto.response.CidadeResponse;
import br.unifei.imc.lojaprodutos.services.CidadeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Cidade Controller")
public class CidadeController {

    private CidadeService cidadeService;

    @GetMapping(value = "/estado/{estadoId}")
    @Operation(summary = "Retorna todos as cidades de um estado")
    public ResponseEntity<List<CidadeResponse>> getAllCitiesByState(@PathVariable Integer estadoId) {
        var cities = cidadeService.getAllCitiesByState(estadoId);

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
}
