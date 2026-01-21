package org.baratieri.tbdistribuidoraauto.controller;

import jakarta.validation.Valid;
import org.baratieri.tbdistribuidoraauto.dto.PecaDTO;
import org.baratieri.tbdistribuidoraauto.entity.Peca;
import org.baratieri.tbdistribuidoraauto.service.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pecas")
public class PecaController {

    @Autowired
    private PecaService service;

    @GetMapping
    public ResponseEntity<List<Peca>> buscarPecas() {
        List<Peca> list = service.listarPecas();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Peca> buscarPecaId(Long id) {
        Peca peca = service.buscarPeca(id);
        return ResponseEntity.ok(peca);
    }

    @PostMapping
    public ResponseEntity<Peca> cadastrar(
            @RequestBody @Valid PecaDTO dto,
            UriComponentsBuilder uriBuilder
    ) {
        // 1. Chama o serviço passando o DTO (o formulário)
        // O serviço faz a conversão e salva no banco
        Peca pecaSalva = service.cadastrarPeca(dto);

        URI uri = uriBuilder.path("/api/pecas/{id}")
                .buildAndExpand(pecaSalva.getId())
                .toUri();

        // 3. Retorna Status 201 (Created) + O objeto salvo no corpo
        return ResponseEntity.created(uri).body(pecaSalva);
    }
}

