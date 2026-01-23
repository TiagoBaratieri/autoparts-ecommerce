package org.baratieri.tbdistribuidoraauto.controller;

import jakarta.validation.Valid;
import org.baratieri.tbdistribuidoraauto.dto.PecaDTO;
import org.baratieri.tbdistribuidoraauto.service.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/pecas")
public class PecaController {

    @Autowired
    private PecaService service;

    @GetMapping
    public ResponseEntity<Page<PecaDTO>> buscarPecas(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String sku,
            @PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        return ResponseEntity.ok().body(service.listarPecas(pageable));
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

