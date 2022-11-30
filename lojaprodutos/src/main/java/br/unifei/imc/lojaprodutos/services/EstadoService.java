package br.unifei.imc.lojaprodutos.services;

import br.unifei.imc.lojaprodutos.dto.response.EstadoResponse;
import br.unifei.imc.lojaprodutos.repositories.EstadoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EstadoService {

  private EstadoRepository estadoRepository;

  private ModelMapper modelMapper;

  public List<EstadoResponse> getAllStates() {
    var states = estadoRepository.findAll();

    return states
        .stream()
        .map(state -> modelMapper.map(state, EstadoResponse.class))
        .collect(Collectors.toList());
  }
}
