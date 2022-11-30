package br.unifei.imc.lojaprodutos.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import br.unifei.imc.lojaprodutos.senders.FinalizaPedidoSender;
import br.unifei.imc.lojaprodutos.senders.messages.ClienteMessage;
import br.unifei.imc.lojaprodutos.senders.messages.EnderecoMessage;
import br.unifei.imc.lojaprodutos.senders.messages.FinalizaPedidoMessage;
import br.unifei.imc.lojaprodutos.senders.messages.ProdutoMessage;
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

  private FinalizaPedidoSender finishOrderSender;

  private ModelMapper modelMapper;

  public String insertOrder(FinalizaPedidoRequest finalizaPedidoRequest) {
    var cliente = getUserDetails();

    Endereco endereco =
        enderecoRepository
            .findById(finalizaPedidoRequest.getAddress().getId())
            .orElseThrow(() -> new ObjectNotFoundException(1, "Endereço não encontrado"));

    var produtos =
        finalizaPedidoRequest
            .getProducts()
            .stream()
            .map(produto -> modelMapper.map(produto, Produto.class))
            .collect(Collectors.toList());

    var pedido = new Pedido();
    pedido.setCustomer(cliente);
    pedido.setDate(Date.from(Instant.now()));
    pedido.setAddress(endereco);
    pedido.setProducts(produtos);
    pedido.setTotalPrice(finalizaPedidoRequest.getTotalPrice());
    pedido.setPayment(finalizaPedidoRequest.getPayment());

    pedidoRepository.save(pedido);

    convertModelToPublishMessage(pedido);

    return "Pedido salvo com sucesso!";
  }

  private Cliente getUserDetails() {
    var usuarioLogado =
        (UsuarioSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    return clienteService.getCustomerById(usuarioLogado.getId());
  }

  private void convertModelToPublishMessage(Pedido pedido) {
    var clienteMessage = modelMapper.map(pedido.getCustomer(), ClienteMessage.class);

    var enderecoMessage = modelMapper.map(pedido.getAddress(), EnderecoMessage.class);

    var produtoMessage = new ArrayList<ProdutoMessage>();
    pedido
        .getProducts()
        .stream()
        .map(
            produto ->
                produtoMessage.add(
                    new ProdutoMessage(produto.getName(), produto.getPrice(), produto.getImage())))
        .collect(Collectors.toList());

    var message = new FinalizaPedidoMessage();
    message.setId(pedido.getId());
    message.setDate(pedido.getDate());
    message.setPayment(pedido.getPayment());
    message.setTotalPrice(pedido.getTotalPrice());
    message.setAddress(enderecoMessage);
    message.setProducts(produtoMessage);
    message.setCustomer(clienteMessage);

    senderOrderToQueue(message);
  }

  private void senderOrderToQueue(FinalizaPedidoMessage finalizaPedidoMessage) {
    finishOrderSender.publishMessage(finalizaPedidoMessage);
  }
}
