package br.unifei.imc.lojaprodutos.services;

import br.unifei.imc.lojaprodutos.models.Endereco;
import br.unifei.imc.lojaprodutos.repositories.ClienteRepository;
import br.unifei.imc.lojaprodutos.repositories.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;
    private EnderecoRepository enderecoRepository;

    public List<Endereco> getAllAddressesByCustomer(Integer id) {
        return enderecoRepository.findAllAddressesByCustomerId(id);
    }
}
