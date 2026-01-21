package org.baratieri.tbdistribuidoraauto.repository;

import org.baratieri.tbdistribuidoraauto.entity.ModeloVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloVeiculoRepository extends JpaRepository<ModeloVeiculo, Long> {

    // Buscar todos os modelos de uma montadora específica
    // O Spring entende que "MontadoraId" se refere ao atributo id dentro do objeto montadora
    List<ModeloVeiculo> findByMontadoraId(Long montadoraId);
}