package br.unifei.imc.lojaprodutos.services;

import br.unifei.imc.lojaprodutos.dto.request.ClienteRequest;
import br.unifei.imc.lojaprodutos.dto.response.ClienteResponse;
import br.unifei.imc.lojaprodutos.dto.response.EnderecoResponse;
import br.unifei.imc.lojaprodutos.dto.response.PedidoResponse;
import br.unifei.imc.lojaprodutos.dto.response.ProdutoResponse;
import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.models.Pedido;
import br.unifei.imc.lojaprodutos.models.Produto;
import br.unifei.imc.lojaprodutos.repositories.ClienteRepository;
import br.unifei.imc.lojaprodutos.repositories.EnderecoRepository;
import br.unifei.imc.lojaprodutos.repositories.PedidoRepository;
import lombok.AllArgsConstructor;

import org.hibernate.ObjectNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteService {

    private EnderecoService enderecoService;
    private ClienteRepository clienteRepository;

    private ModelMapper modelMapper;

    private PasswordEncoder encoder;

    public List<EnderecoResponse> getAllAddressesByCustomer(Integer id) {
        var enderecos = enderecoService.getAllAddressesByCustomerId(id);

        return enderecos.stream()
                .map(endereco -> modelMapper.map(endereco, EnderecoResponse.class))
                .collect(Collectors.toList());
    }

    public Cliente getCustomerById(Integer id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(1, "Usuário não cadastrado."));
    }

    public ClienteResponse insertCustomer(ClienteRequest clienteRequest) {
        var cliente = modelMapper.map(clienteRequest, Cliente.class);
        cliente.setPassword(encoder.encode(clienteRequest.getPassword()));

        var clienteSalvo = clienteRepository.save(cliente);

        return modelMapper.map(clienteSalvo, ClienteResponse.class);
    }

    public List<PedidoResponse> findAllPedidosByClienteId(Integer id){

        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(1, "Cliente não encontrado"));

        List<PedidoResponse> pedidosResponse = new ArrayList<>();

        List<Pedido> pedidos = clienteRepository.findAllPedidosByClienteId(id).orElseThrow(() -> new ObjectNotFoundException(1, "Pedidos não encontrados"));

        pedidos.forEach(pedido -> {

            List<Produto> produtos = clienteRepository.findAllProdutosByClienteAndPedidoId(id, pedido.getId()).orElseThrow(() -> new ObjectNotFoundException(1, "Não foram encontrados produtos para um dos pedidos"));

            pedidosResponse.add(new PedidoResponse(pedido.getId(), pedido.getDate(), produtos.stream().map(produto -> modelMapper.map(produto, ProdutoResponse.class)).collect(Collectors.toList())));

        });

        return pedidosResponse;

    }
}
