package org.baratieri.tbdistribuidoraauto.controller;

import org.baratieri.tbdistribuidoraauto.entity.Peca;
import org.baratieri.tbdistribuidoraauto.service.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
