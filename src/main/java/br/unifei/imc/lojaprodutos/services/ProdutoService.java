package br.unifei.imc.lojaprodutos.services;

import br.unifei.imc.lojaprodutos.models.Produto;
import br.unifei.imc.lojaprodutos.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(final ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAllProducts() {
        return produtoRepository.findAll();
    }

    public List<Produto> getAllProductsByCategory(Integer id) {
        return produtoRepository.findAllProductsByCategory(id);
    }
}
