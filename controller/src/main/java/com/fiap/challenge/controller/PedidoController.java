package com.fiap.challenge.controller;

import com.fiap.challenge.domain.Pedido;
import com.fiap.challenge.service.PedidoApplicationService;
import com.fiap.challenge.service.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoApplicationService pedidoApplicationService;

    @Autowired
    public PedidoController(PedidoApplicationService pedidoApplicationService) {
        this.pedidoApplicationService = pedidoApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> buscarTodos() {
        return ResponseEntity.ok(pedidoApplicationService.listarPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoApplicationService.buscarPedido(id));
    }

    @PostMapping
    public ResponseEntity<String> incluirPedido(@RequestBody PedidoDTO pedidoDTO) {
        pedidoApplicationService.incluirPedido(pedidoDTO);
        return ResponseEntity.ok("Pedido inserido com sucesso.");
    }

    @PutMapping("/{id}/atualizarPedidoParaEmPreparacao")
    public ResponseEntity<String> atualizarPedidoParaEmPreparacao(@PathVariable Long id) {
        pedidoApplicationService.atualizarPedidoParaEmPreparacao(id);
        return ResponseEntity.ok("Pedido atualizado para em preparação.");
    }

    @PutMapping("/{id}/atualizarPedidoParaPronto")
    public ResponseEntity<String> atualizarPedidoParaPronto(@PathVariable Long id) {
        pedidoApplicationService.atualizarPedidoParaPronto(id);
        return ResponseEntity.ok("Pedido atualizado para pronto.");
    }

    @PutMapping("/{id}/atualizarPedidoParaFinalizado")
    public ResponseEntity<String> atualizarPedidoParaFinalizado(@PathVariable Long id) {
        pedidoApplicationService.atualizarPedidoParaFinalizado(id);
        return ResponseEntity.ok("Pedido atualizado para finalizado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPedido(@PathVariable Long id) {
        pedidoApplicationService.deletarPedido(id);
        return ResponseEntity.ok("Pedido excluido com sucesso.");
    }
}