package br.unifei.imc.lojaprodutos.services;

import br.unifei.imc.lojaprodutos.dto.response.CidadeResponse;
import br.unifei.imc.lojaprodutos.repositories.CidadeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CidadeService {

    private CidadeRepository cidadeRepository;

    private ModelMapper modelMapper;

    public List<CidadeResponse> getAllCitiesByState(Integer id) {
        var cities = cidadeRepository.findAllCitiesByState(id);

        return cities.stream()
                .map(citie -> modelMapper.map(citie, CidadeResponse.class))
                .collect(Collectors.toList());
    }
}
