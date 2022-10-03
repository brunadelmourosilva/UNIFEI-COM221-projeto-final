package br.unifei.imc.lojaprodutos.repositories;

import br.unifei.imc.lojaprodutos.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query(value = "SELECT tp.* FROM PRODUTO_CATEGORIA pc " +
            "INNER JOIN TB_CATEGORIA tc ON tc.id = pc.categoria_id " +
            "INNER JOIN TB_PRODUTO tp ON tp.id = pc.produto_id " +
            "WHERE tc.id = ?1", nativeQuery = true)
    List<Produto> findAllProductsByCategory(Integer id);
}
