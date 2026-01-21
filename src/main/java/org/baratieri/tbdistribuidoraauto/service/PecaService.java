package org.baratieri.tbdistribuidoraauto.service;

import org.baratieri.tbdistribuidoraauto.dto.PecaDTO;
import org.baratieri.tbdistribuidoraauto.entity.Categoria;
import org.baratieri.tbdistribuidoraauto.entity.Peca;
import org.baratieri.tbdistribuidoraauto.repository.CategoriaRepository;
import org.baratieri.tbdistribuidoraauto.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PecaService {

    @Autowired
    private PecaRepository repository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Peca> listarPecas() {
        return repository.findAll();
    }

    public Peca buscarPeca(Long id) {
        Optional<Peca> peca = repository.findById(id);
        return peca.orElse(null);
    }

    public Peca cadastrarPeca(PecaDTO dto) {
        // 1. Validar/Buscar Categoria
        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada"));

        // 2. Converter DTO -> Entidade
        Peca novaPeca = dto.toEntity(categoria);

        // 3. Salvar e retornar a Entidade
        return repository.save(novaPeca);

    }
}
