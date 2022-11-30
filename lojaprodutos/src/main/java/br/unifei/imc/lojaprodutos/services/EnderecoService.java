package br.unifei.imc.lojaprodutos.services;

import br.unifei.imc.lojaprodutos.dto.request.ClienteCadastroRequest;
import br.unifei.imc.lojaprodutos.dto.request.ClienteRequest;
import br.unifei.imc.lojaprodutos.dto.response.ClienteResponse;
import br.unifei.imc.lojaprodutos.dto.response.EnderecoResponse;
import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.models.Endereco;
import br.unifei.imc.lojaprodutos.repositories.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EnderecoService {

  private ModelMapper modelMapper;

  private EnderecoRepository enderecoRepository;

  public List<EnderecoResponse> insertAddresses(
      ClienteCadastroRequest clienteCadastroRequest, Cliente cliente) {

    var enderecos =
        clienteCadastroRequest
            .getAddresses()
            .stream()
            .map(endereco -> modelMapper.map(endereco, Endereco.class))
            .collect(Collectors.toList());

    enderecos.forEach(endereco -> endereco.setCustomer(cliente));

    var enderecosSalvos = enderecoRepository.saveAll(enderecos);

    return enderecosSalvos
        .stream()
        .map(endereco -> modelMapper.map(endereco, EnderecoResponse.class))
        .collect(Collectors.toList());
  }

  List<Endereco> getAllAddressesByCustomerId(Integer id) {
    return enderecoRepository.findAllAddressesByCustomerId(id);
  }
}
