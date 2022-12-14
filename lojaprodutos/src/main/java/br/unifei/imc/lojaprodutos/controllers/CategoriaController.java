package br.unifei.imc.lojaprodutos.controllers;

import br.unifei.imc.lojaprodutos.dto.response.CategoriaResponse;
import br.unifei.imc.lojaprodutos.services.CategoriaService;
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
@RequestMapping("/categorias")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Categoria Controller")
public class CategoriaController {

  private CategoriaService categoriaService;

  @GetMapping
  @Operation(summary = "Retorna todas as categorias")
  public ResponseEntity<List<CategoriaResponse>> getAllCategories() {
    var categorias = categoriaService.getAllCategories();

    return new ResponseEntity<>(categorias, HttpStatus.OK);
  }
}
