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

    @Query(nativeQuery = true, value = "SELECT * FROM TB_PEDIDO tp WHERE tp.RF_CLIENTE = ?1")
    Optional<List<Pedido>> findAllPedidosByClienteId(Integer id);

    @Query(nativeQuery = true,
    value = "SELECT tprod.* FROM TB_PEDIDO tp " + 
            "INNER JOIN TB_PRODUTO_PEDIDO tpp ON tpp.RF_PEDIDO = tp.PEDIDO_ID " +
            "INNER JOIN TB_PRODUTO tprod ON tprod.PRODUTO_ID = tpp.RF_PRODUTO " + 
            "WHERE tp.RF_CLIENTE = 1 AND " +
            "tp.PEDIDO_ID = ?2")
    Optional<List<Produto>> findAllProdutosByClienteAndPedidoId(Integer clienteId, Integer pedidoId);
    
}
