package br.unifei.imc.lojaprodutos.services;

import br.unifei.imc.lojaprodutos.models.Produto;
import br.unifei.imc.lojaprodutos.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public List<Produto> getAllProducts() {
        return produtoRepository.findAll();
    }

    public List<Produto> getAllProductsByCategory(Integer id) {
        return produtoRepository.findAllProductsByCategory(id);
    }
}
