package com.fiap.challenge.controller;

import com.fiap.challenge.domain.Produto;
import com.fiap.challenge.service.ProdutoApplicationService;
import com.fiap.challenge.service.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoApplicationService produtoApplicationService;

    @Autowired
    public ProdutoController(ProdutoApplicationService produtoApplicationService) {
        this.produtoApplicationService = produtoApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos() {
        return ResponseEntity.ok(produtoApplicationService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoApplicationService.buscarProduto(id));
    }

    @PostMapping
    public ResponseEntity<String> incluirProduto(@RequestBody ProdutoDTO produtoDTO) {
        produtoApplicationService.incluirProduto(produtoDTO);
        return ResponseEntity.ok("Produto inserido com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        produtoApplicationService.atualizarProduto(id, produtoDTO);
        return ResponseEntity.ok("Produto atualizado com sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        produtoApplicationService.deletarProduto(id);
        return ResponseEntity.ok("Produto excluido com sucesso.");
    }

    @GetMapping("/lanches")
    public ResponseEntity<List<Produto>> buscarLanches() {
        return ResponseEntity.ok(produtoApplicationService.listarLanches());
    }

    @GetMapping("/acompanhamentos")
    public ResponseEntity<List<Produto>> buscarAcompanhamentos() {
        return ResponseEntity.ok(produtoApplicationService.listarAcompanhamentos());
    }

    @GetMapping("/bebidas")
    public ResponseEntity<List<Produto>> buscarBebidas() {
        return ResponseEntity.ok(produtoApplicationService.listarBebidas());
    }

    @GetMapping("/sobremesas")
    public ResponseEntity<List<Produto>> buscarSobremesas() {
        return ResponseEntity.ok(produtoApplicationService.listarSobremesas());
    }
}