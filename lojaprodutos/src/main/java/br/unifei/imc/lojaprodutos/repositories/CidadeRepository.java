package br.unifei.imc.lojaprodutos.repositories;

import br.unifei.imc.lojaprodutos.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

  @Query(value = "SELECT * FROM TB_CIDADE tc WHERE tc.RF_ESTADO = ?1", nativeQuery = true)
  List<Cidade> findAllCitiesByState(Integer id);

  boolean existsById(Integer id);
}
