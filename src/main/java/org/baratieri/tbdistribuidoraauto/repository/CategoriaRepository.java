package org.baratieri.tbdistribuidoraauto.repository;

import org.baratieri.tbdistribuidoraauto.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}