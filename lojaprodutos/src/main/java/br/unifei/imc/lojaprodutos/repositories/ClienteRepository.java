package br.unifei.imc.lojaprodutos.repositories;

import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.models.Pedido;
import br.unifei.imc.lojaprodutos.models.Produto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

  Cliente findByEmail(String email);

  @Query(value = "FROM Pedido p WHERE p.customer.id = ?1")
  Optional<List<Pedido>> findAllPedidosByClienteId(Integer id);

  @Query(
    value =
        "SELECT prod FROM Pedido p "
            + "JOIN p.products prod "
            + "WHERE p.customer.id = ?1 AND "
            + "p.id = ?2"
  )
  Optional<List<Produto>> findAllProdutosByClienteAndPedidoId(Integer clienteId, Integer pedidoId);
}
