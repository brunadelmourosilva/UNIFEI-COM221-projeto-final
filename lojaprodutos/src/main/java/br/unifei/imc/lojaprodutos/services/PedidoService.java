package br.unifei.imc.lojaprodutos.services;

import java.time.Instant;
import java.util.Date;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.unifei.imc.lojaprodutos.dto.request.FinalizaPedidoRequest;
import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.models.Endereco;
import br.unifei.imc.lojaprodutos.models.Pedido;
import br.unifei.imc.lojaprodutos.models.Produto;
import br.unifei.imc.lojaprodutos.repositories.EnderecoRepository;
import br.unifei.imc.lojaprodutos.repositories.PedidoRepository;
import br.unifei.imc.lojaprodutos.security.UsuarioSS;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PedidoService {
    
    private ClienteService clienteService;

    private PedidoRepository pedidoRepository;

    private EnderecoRepository enderecoRepository;

    private ModelMapper modelMapper; 

    public String insertOrder(FinalizaPedidoRequest finalizaPedidoRequest) {
        var cliente = getUserDetails();

        Endereco endereco = enderecoRepository.findById(finalizaPedidoRequest.getEndereco().getId()).orElseThrow(() -> new ObjectNotFoundException(1, "Endereço não encontrado"));


        var produtos = finalizaPedidoRequest.getProdutos()
                        .stream()
                        .map(produto -> modelMapper.map(produto, Produto.class))
                        .collect(Collectors.toList());

        var pedido = new Pedido();
        pedido.setCustomer(cliente);
        pedido.setDate(Date.from(Instant.now()));
        pedido.setEndereco(endereco);
        pedido.setProducts(produtos);
        pedido.setValorTotal(finalizaPedidoRequest.getValorTotal());
        pedido.setPayment(finalizaPedidoRequest.getPayment());

        pedidoRepository.save(pedido);

        return "Pedido salvo com sucesso!";
    }

    public Cliente getUserDetails() {
        var usuarioLogado = (UsuarioSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        return clienteService.getCustomerById(usuarioLogado.getId());
    }
}
