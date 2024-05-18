package com.fiap.challenge.controller;

import com.fiap.challenge.domain.Lanche;
import com.fiap.challenge.service.LancheApplicationService;
import com.fiap.challenge.service.LancheDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lanches")
public class LancheController {
    private final LancheApplicationService lancheApplicationService;

    @Autowired
    public LancheController(LancheApplicationService lancheApplicationService) {
        this.lancheApplicationService = lancheApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<Lanche>> buscarTodos() {
        return ResponseEntity.ok(lancheApplicationService.listarLanches());
    }

    @PostMapping
    public ResponseEntity<Long> incluirCliente(@RequestBody LancheDTO lancheDTO) {
        return ResponseEntity.ok(lancheApplicationService.incluirLanche(lancheDTO));
    }
}