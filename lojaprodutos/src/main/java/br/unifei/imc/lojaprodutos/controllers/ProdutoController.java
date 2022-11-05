package br.unifei.imc.lojaprodutos.controllers;

import br.unifei.imc.lojaprodutos.dto.response.ProdutoResponse;
import br.unifei.imc.lojaprodutos.models.Categoria;
import br.unifei.imc.lojaprodutos.models.Produto;
import br.unifei.imc.lojaprodutos.services.CategoriaService;
import br.unifei.imc.lojaprodutos.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Produto Controller")
public class ProdutoController {

    private ProdutoService produtoService;

    @GetMapping
    @Operation(summary = "Retorna todos os produtos")
    public ResponseEntity<List<ProdutoResponse>> getAllProducts() {
        var produtos = produtoService.getAllProducts();

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(value = "/categoria/{categoriaId}")
    @Operation(summary = "Retorna todos os produtos de uma categoria")
    public ResponseEntity<List<ProdutoResponse>> getAllProductsByCategory(@PathVariable Integer categoriaId) {
        var produtos = produtoService.getAllProductsByCategory(categoriaId);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
}
