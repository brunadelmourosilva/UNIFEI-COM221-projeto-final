package br.unifei.imc.lojaprodutos.services;

import br.unifei.imc.lojaprodutos.dto.response.CategoriaResponse;
import br.unifei.imc.lojaprodutos.repositories.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriaService {

    private CategoriaRepository categoriaRepository;
    private ModelMapper modelMapper;

    public List<CategoriaResponse> getAllCategories() {
        var categorias = categoriaRepository.findAll();

        return categorias.stream()
                .map(categoria -> modelMapper.map(categoria, CategoriaResponse.class))
                .collect(Collectors.toList());
    }
}
