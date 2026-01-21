package org.baratieri.tbdistribuidoraauto.repository;

import org.baratieri.tbdistribuidoraauto.entity.Montadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MontadoraRepository extends JpaRepository<Montadora, Long> {

    // Spring Data cria o SQL sozinho baseado no nome do método!
    // SELECT * FROM tb_montadora WHERE nome = ?
    Optional<Montadora> findByNome(String nome);
}