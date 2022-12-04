package br.unifei.imc.lojaprodutos.services;

import br.unifei.imc.lojaprodutos.dto.request.ClienteCadastroRequest;
import br.unifei.imc.lojaprodutos.dto.request.ClienteRequest;
import br.unifei.imc.lojaprodutos.dto.response.ClienteResponse;
import br.unifei.imc.lojaprodutos.dto.response.EnderecoResponse;
import br.unifei.imc.lojaprodutos.dto.response.PedidoResponse;
import br.unifei.imc.lojaprodutos.dto.response.ProdutoResponse;
import br.unifei.imc.lojaprodutos.exceptions.EmailJaCadastradoException;
import br.unifei.imc.lojaprodutos.exceptions.ObjectNotFoundException;
import br.unifei.imc.lojaprodutos.exceptions.SenhaMenorSeisDigitosException;
import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.models.Pedido;
import br.unifei.imc.lojaprodutos.models.Produto;
import br.unifei.imc.lojaprodutos.models.Role;
import br.unifei.imc.lojaprodutos.repositories.CidadeRepository;
import br.unifei.imc.lojaprodutos.repositories.ClienteRepository;
import br.unifei.imc.lojaprodutos.repositories.EnderecoRepository;
import br.unifei.imc.lojaprodutos.repositories.EstadoRepository;
import br.unifei.imc.lojaprodutos.repositories.PedidoRepository;
import br.unifei.imc.lojaprodutos.repositories.RoleRepository;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteService {

  private EnderecoService enderecoService;
  private ClienteRepository clienteRepository;
  private RoleRepository roleRepository;
  private ModelMapper modelMapper;
  private CidadeRepository cidadeRepository;
  private EstadoRepository estadoRepository;

  private PasswordEncoder encoder;

  public List<EnderecoResponse> getAllAddressesByCustomer(Integer id) {
    var enderecos = enderecoService.getAllAddressesByCustomerId(id);

    return enderecos
        .stream()
        .map(endereco -> modelMapper.map(endereco, EnderecoResponse.class))
        .collect(Collectors.toList());
  }

  public Cliente getCustomerById(Integer id) {
    return clienteRepository
        .findById(id)
        .orElseThrow(() -> new ObjectNotFoundException("Cliente não cadastrado."));
  }

  public ClienteResponse insertCustomer(ClienteCadastroRequest clienteCadastroRequest) {

    validatePassword(clienteCadastroRequest.getPassword());

    validateEmail(clienteCadastroRequest.getEmail());

    var cliente = modelMapper.map(clienteCadastroRequest, Cliente.class);
    cliente.setPassword(encoder.encode(clienteCadastroRequest.getPassword()));

    cliente
        .getAddresses()
        .forEach(
            address -> {
              if (!cidadeRepository.existsById(address.getCity().getId()))
                throw new ObjectNotFoundException("Cidade não cadastrada.");
            });

    var clienteSalvo = clienteRepository.save(cliente);

    roleRepository.save(new Role(null, "ROLE_USER", clienteSalvo));

    var clienteResponse = modelMapper.map(clienteSalvo, ClienteResponse.class);

    var enderecosResponse = enderecoService.insertAddresses(clienteCadastroRequest, clienteSalvo);
    clienteResponse.setAddresses(enderecosResponse);

    return clienteResponse;
  }

  public List<PedidoResponse> findAllPedidosByClienteId(Integer id) {

    Cliente cliente =
        clienteRepository
            .findById(id)
            .orElseThrow(() -> new ObjectNotFoundException("Cliente não cadastrado;"));

    List<PedidoResponse> pedidosResponse = new ArrayList<>();

    List<Pedido> pedidos =
        clienteRepository
            .findAllPedidosByClienteId(id)
            .orElseThrow(
                () ->
                    new ObjectNotFoundException(
                        "Não foram encontrados pedidos para o cliente informado."));

    pedidos.forEach(
        pedido -> {
          List<Produto> produtos =
              clienteRepository
                  .findAllProdutosByClienteAndPedidoId(id, pedido.getId())
                  .orElse(Collections.emptyList());

          pedidosResponse.add(
              new PedidoResponse(
                  pedido.getId(),
                  pedido.getDate(),
                  produtos.isEmpty()
                      ? Collections.emptyList()
                      : produtos
                          .stream()
                          .map(produto -> modelMapper.map(produto, ProdutoResponse.class))
                          .collect(Collectors.toList()),
                  modelMapper.map(pedido.getAddress(), EnderecoResponse.class),
                  pedido.getTotalPrice(),
                  pedido.getPayment()));
        });

    return pedidosResponse;
  }

  private void validatePassword(String password) {
    if (password.length() < 6)
      throw new SenhaMenorSeisDigitosException("A senha informada deve ter mais que 6 digítos.");
  }

  private void validateEmail(String email) {
    if (clienteRepository.findByEmail(email) != null)
      throw new EmailJaCadastradoException("O e-mail informado já está cadastado.");
  }
}
