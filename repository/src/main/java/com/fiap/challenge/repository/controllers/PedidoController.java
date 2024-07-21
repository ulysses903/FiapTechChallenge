package com.fiap.challenge.repository.controllers;

import com.fiap.challenge.domain.entities.pedido.Pedido;
import com.fiap.challenge.domain.entities.pedido.PagamentoAPI;
import com.fiap.challenge.domain.entities.pedido.PagamentoDTO;
import com.fiap.challenge.domain.usecases.pedido.PedidoApplicationService;
import com.fiap.challenge.domain.usecases.pedido.PedidoDTO;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoApplicationService pedidoApplicationService;
    private final PagamentoAPI pagamentoAPI;

    @Autowired
    public PedidoController(PedidoApplicationService pedidoApplicationService, PagamentoAPI pagamentoAPI) {
        this.pedidoApplicationService = pedidoApplicationService;
        this.pagamentoAPI = pagamentoAPI;
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
    public ResponseEntity<PagamentoDTO> incluirPedido(@RequestBody PedidoDTO pedidoDTO) throws MPException, MPApiException {
        return ResponseEntity.ok(pedidoApplicationService.incluirPedido(pedidoDTO));
    }

    @PutMapping("/{id}/confirmarPagamento")
    public ResponseEntity<String> atualizarPedidoParaRecebido(@PathVariable Long id) {
        pedidoApplicationService.atualizarPedidoParaRecebido(id);
        return ResponseEntity.ok("Pedido atualizado para em preparação.");
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

    @DeleteMapping("/{id}/cancelar")
    public ResponseEntity<String> deletarPedido(@PathVariable Long id) {
        pedidoApplicationService.deletarPedido(id);
        return ResponseEntity.ok("Pedido excluido com sucesso.");
    }
}