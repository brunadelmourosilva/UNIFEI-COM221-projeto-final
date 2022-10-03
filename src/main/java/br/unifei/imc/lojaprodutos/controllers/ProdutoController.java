package br.unifei.imc.lojaprodutos.controllers;

import br.unifei.imc.lojaprodutos.models.Categoria;
import br.unifei.imc.lojaprodutos.models.Produto;
import br.unifei.imc.lojaprodutos.services.CategoriaService;
import br.unifei.imc.lojaprodutos.services.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProducts() {
        var produtos = produtoService.getAllProducts();

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(value = "/categoria/{id}")
    public ResponseEntity<List<Produto>> getAllProductsByCategory(@PathVariable Integer id) {
        var produtos = produtoService.getAllProductsByCategory(id);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
}
