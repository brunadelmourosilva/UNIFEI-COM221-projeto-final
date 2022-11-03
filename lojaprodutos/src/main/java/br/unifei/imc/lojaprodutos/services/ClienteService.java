package br.unifei.imc.lojaprodutos.services;

import br.unifei.imc.lojaprodutos.dto.request.ClienteRequest;
import br.unifei.imc.lojaprodutos.dto.response.ClienteResponse;
import br.unifei.imc.lojaprodutos.dto.response.EnderecoResponse;
import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.models.Endereco;
import br.unifei.imc.lojaprodutos.repositories.ClienteRepository;
import br.unifei.imc.lojaprodutos.repositories.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;
    private EnderecoRepository enderecoRepository;
    private ModelMapper modelMapper;

    public List<EnderecoResponse> getAllAddressesByCustomer(Integer id) {
        var enderecos = enderecoRepository.findAllAddressesByCustomerId(id);

        return enderecos.stream()
                .map(endereco -> modelMapper.map(endereco, EnderecoResponse.class))
                .collect(Collectors.toList());
    }

    public ClienteResponse insertCustomer(ClienteRequest clienteRequest) {
       var cliente = modelMapper.map(clienteRequest, Cliente.class);

        var clienteSalvo = clienteRepository.save(cliente);

        return modelMapper.map(clienteSalvo, ClienteResponse.class);
    }
}
