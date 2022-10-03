package br.unifei.imc.lojaprodutos.controllers;

import br.unifei.imc.lojaprodutos.models.Categoria;
import br.unifei.imc.lojaprodutos.services.CategoriaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
public class CategoriaController {

    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategories() {
        var categorias = categoriaService.getAllCategories();

        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
}
