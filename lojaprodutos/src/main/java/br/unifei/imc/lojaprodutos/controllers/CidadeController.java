package br.unifei.imc.lojaprodutos.controllers;

import br.unifei.imc.lojaprodutos.dto.response.CidadeResponse;
import br.unifei.imc.lojaprodutos.services.CidadeService;
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
@RequestMapping("/cidades")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Cidade Controller")
public class CidadeController {

    private CidadeService cidadeService;

    @GetMapping
    @Operation(summary = "Retorna todos as cidades cadastradas")
    public ResponseEntity<List<CidadeResponse>> getAllCities() {
        var cities = cidadeService.getAllCities();

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
}
