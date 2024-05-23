package com.fiap.challenge.controller;

import com.fiap.challenge.domain.pedido.combo.produto.Acompanhamento;
import com.fiap.challenge.domain.pedido.combo.produto.Bebida;
import com.fiap.challenge.domain.pedido.combo.produto.Lanche;
import com.fiap.challenge.domain.pedido.combo.produto.Sobremesa;
import com.fiap.challenge.service.pedido.combo.produto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final LancheApplicationService lancheApplicationService;
    private final AcompanhamentoApplicationService acompanhamentoApplicationService;
    private final BebidaApplicationService bebidaApplicationService;
    private final SobremesaApplicationService sobremesaApplicationService;

    @Autowired
    public ProdutoController(LancheApplicationService lancheApplicationService,
                             AcompanhamentoApplicationService acompanhamentoApplicationService,
                             BebidaApplicationService bebidaApplicationService,
                             SobremesaApplicationService sobremesaApplicationService) {
        this.lancheApplicationService = lancheApplicationService;
        this.acompanhamentoApplicationService = acompanhamentoApplicationService;
        this.bebidaApplicationService = bebidaApplicationService;
        this.sobremesaApplicationService = sobremesaApplicationService;
    }

    @PostMapping("/lanches")
    public ResponseEntity<String> incluirLanche(@RequestBody LancheDTO lancheDTO) {
        lancheApplicationService.incluirLanche(lancheDTO);
        return ResponseEntity.ok("Lanche inserido com sucesso.");
    }

    @GetMapping("/lanches")
    public ResponseEntity<List<Lanche>> buscarLanches() {
        return ResponseEntity.ok(lancheApplicationService.listarLanches());
    }

    @GetMapping("/lanches/{id}")
    public ResponseEntity<Lanche> buscarLanche(@PathVariable Long id) {
        return ResponseEntity.ok(lancheApplicationService.buscarLanche(id));
    }

    @PutMapping("lanches/{id}")
    public ResponseEntity<String> atualizarLanche(@PathVariable Long id, @RequestBody LancheDTO lancheDTO) {
        lancheApplicationService.atualizarLanche(id, lancheDTO);
        return ResponseEntity.ok("Lanche atualizado para finalizado.");
    }

    @DeleteMapping("lanches/{id}")
    public ResponseEntity<String> deletarLanche(@PathVariable Long id) {
        lancheApplicationService.deletarLanche(id);
        return ResponseEntity.ok("Lanche excluido com sucesso.");
    }

    @PostMapping("/acompanhamentos")
    public ResponseEntity<String> incluirAcompanhamento(@RequestBody AcompanhamentoDTO acompanhamentoDTO) {
        acompanhamentoApplicationService.incluirAcompanhamento(acompanhamentoDTO);
        return ResponseEntity.ok("Acompanhamento inserido com sucesso.");
    }

    @GetMapping("/acompanhamentos")
    public ResponseEntity<List<Acompanhamento>> buscarAcompanhamentos() {
        return ResponseEntity.ok(acompanhamentoApplicationService.listarAcompanhamentos());
    }

    @GetMapping("/acompanhamentos/{id}")
    public ResponseEntity<Acompanhamento> buscarAcompanhamento(@PathVariable Long id) {
        return ResponseEntity.ok(acompanhamentoApplicationService.buscarAcompanhamento(id));
    }

    @PutMapping("acompanhamentos/{id}")
    public ResponseEntity<String> atualizarAcompanhamento(@PathVariable Long id, @RequestBody AcompanhamentoDTO acompanhamentoDTO) {
        acompanhamentoApplicationService.atualizarAcompanhamento(id, acompanhamentoDTO);
        return ResponseEntity.ok("Acompanhamento atualizado para finalizado.");
    }

    @DeleteMapping("acompanhamentos/{id}")
    public ResponseEntity<String> deletarAcompanhamento(@PathVariable Long id) {
        acompanhamentoApplicationService.deletarAcompanhamento(id);
        return ResponseEntity.ok("Acompanhamento excluido com sucesso.");
    }

    @PostMapping("/bebidas")
    public ResponseEntity<String> incluirBebida(@RequestBody BebidaDTO bebidaDTO) {
        bebidaApplicationService.incluirBebida(bebidaDTO);
        return ResponseEntity.ok("Bebida inserido com sucesso.");
    }

    @GetMapping("/bebidas")
    public ResponseEntity<List<Bebida>> buscarBebidas() {
        return ResponseEntity.ok(bebidaApplicationService.listarBebidas());
    }

    @GetMapping("/bebidas/{id}")
    public ResponseEntity<Bebida> buscarBebida(@PathVariable Long id) {
        return ResponseEntity.ok(bebidaApplicationService.buscarBebida(id));
    }

    @PutMapping("bebidas/{id}")
    public ResponseEntity<String> atualizarBebida(@PathVariable Long id, @RequestBody BebidaDTO bebidaDTO) {
        bebidaApplicationService.atualizarBebida(id, bebidaDTO);
        return ResponseEntity.ok("Bebida atualizado para finalizado.");
    }

    @DeleteMapping("bebidas/{id}")
    public ResponseEntity<String> deletarBebida(@PathVariable Long id) {
        bebidaApplicationService.deletarBebida(id);
        return ResponseEntity.ok("Bebida excluido com sucesso.");
    }

    @PostMapping("/sobremesas")
    public ResponseEntity<String> incluirSobremesa(@RequestBody SobremesaDTO sobremesaDTO) {
        sobremesaApplicationService.incluirSobremesa(sobremesaDTO);
        return ResponseEntity.ok("Sobremesa inserido com sucesso.");
    }

    @GetMapping("/sobremesas")
    public ResponseEntity<List<Sobremesa>> buscarSobremesas() {
        return ResponseEntity.ok(sobremesaApplicationService.listarSobremesas());
    }

    @GetMapping("/sobremesas/{id}")
    public ResponseEntity<Sobremesa> buscarSobremesa(@PathVariable Long id) {
        return ResponseEntity.ok(sobremesaApplicationService.buscarSobremesa(id));
    }

    @PutMapping("sobremesas/{id}")
    public ResponseEntity<String> atualizarSobremesa(@PathVariable Long id, @RequestBody SobremesaDTO sobremesaDTO) {
        sobremesaApplicationService.atualizarSobremesa(id, sobremesaDTO);
        return ResponseEntity.ok("Sobremesa atualizado para finalizado.");
    }

    @DeleteMapping("sobremesas/{id}")
    public ResponseEntity<String> deletarSobremesa(@PathVariable Long id) {
        sobremesaApplicationService.deletarSobremesa(id);
        return ResponseEntity.ok("Sobremesa excluido com sucesso.");
    }
}