package org.baratieri.tbdistribuidoraauto.controller;

import jakarta.validation.Valid;
import org.baratieri.tbdistribuidoraauto.dto.PecaDTO;
import org.baratieri.tbdistribuidoraauto.service.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pecas")
public class PecaController {

    @Autowired
    private PecaService service;

    @GetMapping
    public ResponseEntity<List<PecaDTO>> buscarPecas() {
        List<PecaDTO> list = service.listarPecas();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PecaDTO> buscarPecaId(Long id) {
        PecaDTO peca = service.buscarPeca(id);
        return ResponseEntity.ok(peca);
    }

    @PostMapping
    public ResponseEntity<PecaDTO> cadastrar(@RequestBody @Valid PecaDTO dto) {
      dto = service.cadastrarPeca(dto);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
              .buildAndExpand(dto.id()).toUri();
      return ResponseEntity.created(uri).body(dto);
    }
}

