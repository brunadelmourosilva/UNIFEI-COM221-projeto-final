package br.unifei.imc.lojaprodutos.services;

import br.unifei.imc.lojaprodutos.dto.response.CidadeResponse;
import br.unifei.imc.lojaprodutos.exceptions.ObjectNotFoundException;
import br.unifei.imc.lojaprodutos.repositories.CidadeRepository;
import br.unifei.imc.lojaprodutos.repositories.EstadoRepository;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CidadeService {

    private CidadeRepository cidadeRepository;
    private EstadoRepository estadoRepository;
    private ModelMapper modelMapper;

    public List<CidadeResponse> getAllCitiesByState(Integer id) {

        if(!estadoRepository.existsById(id)) throw new ObjectNotFoundException("Estado não cadastrado.");

        var cities = cidadeRepository.findAllCitiesByState(id);

        return cities.stream()
                .map(citie -> modelMapper.map(citie, CidadeResponse.class))
                .collect(Collectors.toList());
    }
}
