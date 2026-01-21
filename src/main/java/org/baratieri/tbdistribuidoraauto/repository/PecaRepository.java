package org.baratieri.tbdistribuidoraauto.repository;

import org.baratieri.tbdistribuidoraauto.entity.Peca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {

    // Buscar peça pelo código SKU
    Optional<Peca> findBySku(String sku);

    // Buscar peças que contêm X no nome (busca "like")
    // Ex: Se digitar "Freio", traz "Disco de Freio", "Pastilha de Freio"
    List<Peca> findByNomeContainingIgnoreCase(String nome);
}