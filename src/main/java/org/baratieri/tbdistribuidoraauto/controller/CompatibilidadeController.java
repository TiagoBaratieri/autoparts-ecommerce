package org.baratieri.tbdistribuidoraauto.controller;

import org.baratieri.tbdistribuidoraauto.entity.Compatibilidade;
import org.baratieri.tbdistribuidoraauto.service.CompatibilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compatibilidades") // URL base diferente
public class CompatibilidadeController {

    @Autowired
    private CompatibilidadeService service;

    // URL final: /api/compatibilidades/veiculo/1
    @GetMapping("/veiculo/{modeloId}")
    public List<Compatibilidade> listarPorCarro(@PathVariable Long modeloId) {
        return service.buscarPecasPorCarro(modeloId);
    }
}