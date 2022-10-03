package br.unifei.imc.lojaprodutos;

import br.unifei.imc.lojaprodutos.factory.*;
import br.unifei.imc.lojaprodutos.models.*;
import br.unifei.imc.lojaprodutos.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	public static void main(String[] args) {
		SpringApplication.run(LojaprodutosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Categoria> categorias = CategoriaFactory.createCategorias();
		List<Produto> produtos = ProdutoFactory.createProdutos(categorias);
		List<Estado> estados = EstadoFactory.createEstados();
		List<Cidade> cidades = CidadeFactory.createCidades(estados);
		Cliente cliente = ClienteFactory.createCliente();
		List<Endereco> enderecos = EnderecoFactory.createEnderecos(cliente, cidades.get(0));

		categoriaRepository.saveAll(categorias);
		produtoRepository.saveAll(produtos);
		estadoRepository.saveAll(estados);
		cidadeRepository.saveAll(cidades);
		clienteRepository.save(cliente);
		enderecoRepository.saveAll(enderecos);

	}
}
