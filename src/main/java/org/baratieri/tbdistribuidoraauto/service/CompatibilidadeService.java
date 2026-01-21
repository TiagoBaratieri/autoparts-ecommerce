package org.baratieri.tbdistribuidoraauto.service;

import org.baratieri.tbdistribuidoraauto.dto.CompatibilidadeDTO;
import org.baratieri.tbdistribuidoraauto.dto.PecaDTO;
import org.baratieri.tbdistribuidoraauto.entity.Compatibilidade;
import org.baratieri.tbdistribuidoraauto.entity.ModeloVeiculo;
import org.baratieri.tbdistribuidoraauto.entity.Peca;
import org.baratieri.tbdistribuidoraauto.repository.CompatibilidadeRepository;
import org.baratieri.tbdistribuidoraauto.repository.ModeloVeiculoRepository;
import org.baratieri.tbdistribuidoraauto.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CompatibilidadeService {

    @Autowired
    private CompatibilidadeRepository repository;

    @Autowired
    private ModeloVeiculoRepository modeloVeiculoRepository;

    @Autowired
    private PecaRepository pecaRepository;

    public List<Compatibilidade> buscarPecasPorCarro(Long modeloId) {
        if (!modeloVeiculoRepository.existsById(modeloId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado com ID: " + modeloId);
        }
        
        return repository.findByModeloVeiculoId(modeloId);
    }

    public Compatibilidade cadastrar(CompatibilidadeDTO dto) {
        Peca peca = pecaRepository.findById(dto.pecaId()).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Peca inexistente"));

        ModeloVeiculo modelo = modeloVeiculoRepository.findById(dto.modeloId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo inexistente"));
        Compatibilidade novaCompatibilidade = dto.toEntity(peca, modelo);
        return repository.save(novaCompatibilidade);


    }
}
