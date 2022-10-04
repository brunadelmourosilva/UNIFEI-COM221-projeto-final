package br.unifei.imc.lojaprodutos.services;

import br.unifei.imc.lojaprodutos.dto.response.ProdutoResponse;
import br.unifei.imc.lojaprodutos.models.Produto;
import br.unifei.imc.lojaprodutos.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    private ModelMapper modelMapper;

    public List<ProdutoResponse> getAllProducts() {
        var produtos = produtoRepository.findAll();

        return produtos.stream()
                .map(produto -> modelMapper.map(produto, ProdutoResponse.class))
                .collect(Collectors.toList());
    }

    public List<ProdutoResponse> getAllProductsByCategory(Integer id) {
        var produtos = produtoRepository.findAllProductsByCategory(id);

        return produtos.stream()
                .map(produto -> modelMapper.map(produto, ProdutoResponse.class))
                .collect(Collectors.toList());
    }
}
