package br.unifei.imc.lojaprodutos.repositories;

import br.unifei.imc.lojaprodutos.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query(value = "SELECT * FROM TB_ENDERECO te WHERE te.RF_CLIENTE = ?1", nativeQuery = true)
    List<Endereco> findAllAddressesByCustomerId(Integer clienteId);
}
