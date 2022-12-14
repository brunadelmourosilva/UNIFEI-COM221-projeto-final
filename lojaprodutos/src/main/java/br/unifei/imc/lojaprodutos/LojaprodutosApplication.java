package br.unifei.imc.lojaprodutos;

import br.unifei.imc.lojaprodutos.factory.*;
import br.unifei.imc.lojaprodutos.models.*;
import br.unifei.imc.lojaprodutos.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class LojaprodutosApplication implements CommandLineRunner {

  private CategoriaRepository categoriaRepository;
  private ProdutoRepository produtoRepository;
  private EstadoRepository estadoRepository;
  private CidadeRepository cidadeRepository;
  private ClienteRepository clienteRepository;
  private EnderecoRepository enderecoRepository;
  private CartaoRepository cartaoRepository;
  private RoleRepository roleRepository;
  private PasswordEncoder passwordEncoder;
  private PedidoRepository pedidoRepository;

  public static void main(String[] args) {
    SpringApplication.run(LojaprodutosApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    ClienteFactory clienteFactory = new ClienteFactory(passwordEncoder);

    List<Categoria> categorias = CategoriaFactory.createCategorias();
    List<Produto> produtos = ProdutoFactory.createProdutos(categorias);
    List<Estado> estados = EstadoFactory.createEstados();
    List<Cidade> cidades = CidadeFactory.createCidades(estados);
    Cliente cliente = clienteFactory.createCliente();
    List<Endereco> enderecos = EnderecoFactory.createEnderecos(cliente, cidades.get(0));
    List<Cartao> cartoes = CartaoFactory.createCartoes(cliente);

    categoriaRepository.saveAll(categorias);
    produtoRepository.saveAll(produtos);
    estadoRepository.saveAll(estados);
    cidadeRepository.saveAll(cidades);
    clienteRepository.save(cliente);
    enderecoRepository.saveAll(enderecos);

    //TODO: CORRIGIR ISSO

    Pedido pedido =
        new Pedido(
            null,
            Date.from(Instant.now()),
            cliente,
            new ArrayList<>(),
            enderecos.get(0),
            10550d,
            1);

    for (int i = 0; i < 3; i++) {
      pedido.getProducts().add(produtos.get(i));
    }

    pedidoRepository.save(pedido);
    cartaoRepository.saveAll(cartoes);

    roleRepository.saveAll(List.of(new Role(null, "ROLE_USER", cliente)));
  }
}
