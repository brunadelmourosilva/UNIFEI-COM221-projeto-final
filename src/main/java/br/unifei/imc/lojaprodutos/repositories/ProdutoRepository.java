package br.unifei.imc.lojaprodutos.repositories;

import br.unifei.imc.lojaprodutos.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query(value = "SELECT DISTINCT tp.* FROM TB_PRODUTO_CATEGORIA pc " +
            "INNER JOIN TB_CATEGORIA tc ON tc.CATEGORIA_ID = pc.RF_CATEGORIA " +
            "INNER JOIN TB_PRODUTO tp ON tp.PRODUTO_ID = pc.RF_PRODUTO " +
            "WHERE tc.CATEGORIA_ID = ?1", nativeQuery = true)
    List<Produto> findAllProductsByCategory(Integer id);
}
