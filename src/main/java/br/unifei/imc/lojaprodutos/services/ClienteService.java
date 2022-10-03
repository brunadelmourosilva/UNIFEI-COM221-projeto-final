package br.unifei.imc.lojaprodutos.services;

import br.unifei.imc.lojaprodutos.models.Endereco;
import br.unifei.imc.lojaprodutos.repositories.ClienteRepository;
import br.unifei.imc.lojaprodutos.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private EnderecoRepository enderecoRepository;

    public ClienteService(final ClienteRepository clienteRepository, final EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> getAllAddressesByCustomer(Integer id) {
        return enderecoRepository.findAllAddressesByCustomer(id);
    }

}
