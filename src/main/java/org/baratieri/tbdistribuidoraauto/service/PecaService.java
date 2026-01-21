package org.baratieri.tbdistribuidoraauto.service;

import org.baratieri.tbdistribuidoraauto.entity.Peca;
import org.baratieri.tbdistribuidoraauto.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PecaService {

    @Autowired
    private PecaRepository repository;

    public List<Peca> listarPecas() {
        return repository.findAll();
    }

    public Peca buscarPeca(Long id) {
        Optional<Peca> peca = repository.findById(id);
        return peca.orElse(null);
    }
}
