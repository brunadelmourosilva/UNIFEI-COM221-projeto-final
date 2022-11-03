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

    @GetMapping(value = "/estado/{id}")
    @Operation(summary = "Retorna todos as cidades cadastradas")
    public ResponseEntity<List<CidadeResponse>> getAllCitiesByState(@PathVariable Integer id) {
        var cities = cidadeService.getAllCitiesByState(id);

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
}
