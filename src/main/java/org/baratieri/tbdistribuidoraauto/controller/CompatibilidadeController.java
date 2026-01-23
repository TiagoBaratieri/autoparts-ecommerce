package org.baratieri.tbdistribuidoraauto.controller;

import jakarta.validation.Valid;
import org.baratieri.tbdistribuidoraauto.dto.CompatibilidadeDTO;

import org.baratieri.tbdistribuidoraauto.service.CompatibilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/compatibilidades") // URL base diferente
public class CompatibilidadeController {

    @Autowired
    private CompatibilidadeService service;


    @GetMapping("/veiculo/{modeloId}")
    public List<CompatibilidadeDTO> listarPorCarro(@PathVariable Long modeloId) {
        return service.buscarPecasPorCarro(modeloId);
    }

    @PostMapping
    public ResponseEntity<CompatibilidadeDTO> cadastrar(@RequestBody @Valid CompatibilidadeDTO dto,
                                                     UriComponentsBuilder uriBuilder) {
        CompatibilidadeDTO salva = service.cadastrar(dto);

        URI uri = uriBuilder.path("/api/compatibilidades/{id}")
                .buildAndExpand(salva.id()).toUri();

        return ResponseEntity.created(uri).body(salva);
    }
}