package org.baratieri.tbdistribuidoraauto.service;

import org.baratieri.tbdistribuidoraauto.dto.PecaDTO;
import org.baratieri.tbdistribuidoraauto.entity.Categoria;
import org.baratieri.tbdistribuidoraauto.entity.Peca;
import org.baratieri.tbdistribuidoraauto.repository.CategoriaRepository;
import org.baratieri.tbdistribuidoraauto.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PecaService {

    @Autowired
    private PecaRepository repository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<PecaDTO> listarPecas() {
        return repository.findAll()
                .stream()
                .map(PecaDTO::fromEntity)
                .toList();
    }

    public PecaDTO buscarPeca(Long id) {
        Optional<Peca> obj = repository.findById(id);
        Peca peca = obj.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Peça não encontrdas"));
        return PecaDTO.fromEntity(peca);
    }

    public PecaDTO cadastrarPeca(PecaDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada"));
        Peca novaPeca = dto.toEntity(categoria);

        Peca pecaSalva = repository.save(novaPeca);
        return PecaDTO.fromEntity(pecaSalva);

    }
}
