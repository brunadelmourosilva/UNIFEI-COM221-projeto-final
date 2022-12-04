package br.unifei.imc.lojaprodutos.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.unifei.imc.lojaprodutos.builders.ClienteBuilder;
import br.unifei.imc.lojaprodutos.dto.request.CidadeRequest;
import br.unifei.imc.lojaprodutos.dto.request.ClienteCadastroRequest;
import br.unifei.imc.lojaprodutos.dto.request.EnderecoCadastroRequest;
import br.unifei.imc.lojaprodutos.dto.request.EstadoRequest;
import br.unifei.imc.lojaprodutos.dto.response.CidadeResponse;
import br.unifei.imc.lojaprodutos.dto.response.EnderecoResponse;
import br.unifei.imc.lojaprodutos.dto.response.EstadoResponse;
import br.unifei.imc.lojaprodutos.exceptions.EmailJaCadastradoException;
import br.unifei.imc.lojaprodutos.exceptions.ObjectNotFoundException;
import br.unifei.imc.lojaprodutos.exceptions.SenhaMenorSeisDigitosException;
import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.repositories.CidadeRepository;
import br.unifei.imc.lojaprodutos.repositories.ClienteRepository;
import br.unifei.imc.lojaprodutos.repositories.EstadoRepository;
import br.unifei.imc.lojaprodutos.repositories.RoleRepository;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

  @InjectMocks private ClienteService clienteService;

  @Mock(lenient = true)
  private EnderecoService enderecoService;

  @Mock(lenient = true)
  private ClienteRepository clienteRepository;

  @Mock(lenient = true)
  private RoleRepository roleRepository;

  @Spy private ModelMapper modelMapper;

  @Mock(lenient = true)
  private CidadeRepository cidadeRepository;

  @Mock(lenient = true)
  private EstadoRepository estadoRepository;

  @Spy private PasswordEncoder encoder;

  private ClienteCadastroRequest clienteCadastroRequest;

  private EnderecoCadastroRequest enderecoCadastroRequest;

  private CidadeRequest cidadeRequest;

  private EstadoRequest estadoRequest;

  private Cliente clienteSalvo;

  private List<EnderecoResponse> listEnderecoResponse = new ArrayList<>();

  private CidadeResponse cidadeResponse;

  private EstadoResponse estadoResponse;

  @BeforeEach
  void setup() {
    estadoRequest = new EstadoRequest(1, "São Paulo");

    cidadeRequest = new CidadeRequest(1, "Campinas", estadoRequest);

    estadoResponse = new EstadoResponse(estadoRequest.getId(), estadoRequest.getName());

    cidadeResponse =
        new CidadeResponse(cidadeRequest.getId(), cidadeRequest.getName(), estadoResponse);

    enderecoCadastroRequest =
        new EnderecoCadastroRequest(
            "Rua Marcelino", "333", "Casa", "Centro", "35555555", cidadeRequest);

    clienteCadastroRequest =
        new ClienteCadastroRequest(
            "Gabriel", "gabriel@gmail.com", "1234567", List.of(enderecoCadastroRequest));

    clienteSalvo =
        ClienteBuilder.builder()
            .email(clienteCadastroRequest.getEmail())
            .name(clienteCadastroRequest.getName())
            .password(clienteCadastroRequest.getPassword())
            .build();

    listEnderecoResponse.add(
        new EnderecoResponse(
            1,
            enderecoCadastroRequest.getStreet(),
            enderecoCadastroRequest.getNumber(),
            enderecoCadastroRequest.getComplement(),
            enderecoCadastroRequest.getNeighborhood(),
            enderecoCadastroRequest.getZipCode(),
            cidadeResponse));
  }

  @Test
  void insertCustomer_DeveCadastrarComSucesso_QuandoEmailNaoEstaCadastrado() {

    BDDMockito.given(clienteRepository.findByEmail("gabriel@gmail.com")).willReturn(null);
    BDDMockito.given(cidadeRepository.existsById(any())).willReturn(true);
    BDDMockito.given(clienteRepository.save(any())).willReturn(clienteSalvo);
    BDDMockito.given(enderecoService.insertAddresses(any(), any()))
        .willReturn(listEnderecoResponse);

    var result = clienteService.insertCustomer(clienteCadastroRequest);

    BDDMockito.then(clienteRepository)
        .should(times(1))
        .findByEmail(clienteCadastroRequest.getEmail());
    BDDMockito.then(cidadeRepository).should(times(1)).existsById(any());
    BDDMockito.then(clienteRepository).should(times(1)).save(any());
    BDDMockito.then(enderecoService).should(times(1)).insertAddresses(any(), any());

    assertNotNull(result.getName());
    assertNotNull(result.getEmail());
    assertNotNull(result.getAddresses());
  }

  @Test
  void insertCustomer_DeveLancarException_QuandoEmailInformadoJaEstaCadastrado() {

    BDDMockito.given(clienteRepository.findByEmail("gabriel@gmail.com")).willReturn(clienteSalvo);
    BDDMockito.given(cidadeRepository.existsById(any())).willReturn(true);
    BDDMockito.given(clienteRepository.save(any())).willReturn(clienteSalvo);
    BDDMockito.given(enderecoService.insertAddresses(any(), any()))
        .willReturn(listEnderecoResponse);

    var exception =
        assertThrows(
            EmailJaCadastradoException.class,
            () -> clienteService.insertCustomer(clienteCadastroRequest));

    BDDMockito.then(clienteRepository)
        .should(times(1))
        .findByEmail(clienteCadastroRequest.getEmail());
    BDDMockito.then(cidadeRepository).should(times(0)).existsById(any());
    BDDMockito.then(clienteRepository).should(times(0)).save(any());
    BDDMockito.then(enderecoService).should(times(0)).insertAddresses(any(), any());

    assertEquals("O e-mail informado já está cadastado.", exception.getMessage());
  }

  @Test
  void insertCustomer_DeveLancarException_QuandoCidadeNaoEcontrada() {

    BDDMockito.given(clienteRepository.findByEmail("gabriel@gmail.com")).willReturn(null);
    BDDMockito.given(cidadeRepository.existsById(any())).willReturn(false);

    var exception =
        assertThrows(
            ObjectNotFoundException.class,
            () -> clienteService.insertCustomer(clienteCadastroRequest));

    BDDMockito.then(clienteRepository)
        .should(times(1))
        .findByEmail(clienteCadastroRequest.getEmail());
    BDDMockito.then(cidadeRepository).should(times(1)).existsById(any());

    assertEquals("Cidade não cadastrada.", exception.getMessage());
  }

  @Test
  void insertCustomer_DeveLancarException_QuandoSenhaMenorQueSeisDigitos() {

    clienteCadastroRequest.setPassword("123");

    var exception =
        assertThrows(
            SenhaMenorSeisDigitosException.class,
            () -> clienteService.insertCustomer(clienteCadastroRequest));

    assertEquals("A senha informada deve ter mais que 6 digítos.", exception.getMessage());
  }
}
