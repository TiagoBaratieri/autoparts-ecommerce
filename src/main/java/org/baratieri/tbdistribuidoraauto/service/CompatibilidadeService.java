package org.baratieri.tbdistribuidoraauto.service;

import org.baratieri.tbdistribuidoraauto.entity.Compatibilidade;
import org.baratieri.tbdistribuidoraauto.repository.CompatibilidadeRepository;
import org.baratieri.tbdistribuidoraauto.repository.ModeloVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CompatibilidadeService {

    @Autowired
    private CompatibilidadeRepository repository;

    @Autowired
    private ModeloVeiculoRepository modeloVeiculoRepository;

    public List<Compatibilidade> buscarPecasPorCarro(Long modeloId) {
        // 4. A Regra de Ouro: Validação antes da Ação
        // "Existe algum veículo com esse ID?"
        if (!modeloVeiculoRepository.existsById(modeloId)) {
            // Se não existe, paramos tudo e lançamos um erro 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado com ID: " + modeloId);
        }

        // Se passou pelo if, o carro existe. Buscamos as peças.
        return repository.findByModeloVeiculoId(modeloId);
    }
}
