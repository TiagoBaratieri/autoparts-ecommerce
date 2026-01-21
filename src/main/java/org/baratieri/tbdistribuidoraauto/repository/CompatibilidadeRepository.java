package org.baratieri.tbdistribuidoraauto.repository;


import org.baratieri.tbdistribuidoraauto.entity.Compatibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompatibilidadeRepository extends JpaRepository<Compatibilidade, Long> {

    // A Query que responde: "Quais peças servem neste carro?"
    // Tradução: Busque compatibilidades onde o modeloVeiculo.id seja igual ao parametro
    List<Compatibilidade> findByModeloVeiculoId(Long modeloId);
}