package br.unifei.imc.lojaprodutos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unifei.imc.lojaprodutos.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {}
