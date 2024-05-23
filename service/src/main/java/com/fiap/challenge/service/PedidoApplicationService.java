package com.fiap.challenge.service;

import com.fiap.challenge.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoApplicationService {
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;
    private final ComboApplicationService comboApplicationService;

    @Autowired
    public PedidoApplicationService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository,
                                    ClienteRepository clienteRepository, ComboApplicationService comboApplicationService) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
        this.comboApplicationService = comboApplicationService;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPedido(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
    }

    @Transactional
    public void incluirPedido(PedidoDTO pedidoDTO) {
        List<Combo> combos = comboApplicationService.adicionarCombos(pedidoDTO.getCombos());
        if (combos.isEmpty()) {
            throw new RuntimeException("Pelo menos um produto deve ser informado para criar um pedido");
        }
        Cliente cliente = clienteRepository.findById(pedidoDTO.getCliente().getId()).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        Pedido pedido = new Pedido(combos, cliente);
        pedidoRepository.save(pedido);
    }

    @Transactional
    public void deletarPedido(Long idDoPedido) {
        Pedido pedido = pedidoRepository.findById(idDoPedido).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedidoRepository.delete(pedido);
    }

    public void atualizarPedidoParaEmPreparacao(Long idDoPedido) {
        alterarStatusDoPedido(idDoPedido, StatusDoPedido.EM_PREPARACAO);
    }

    public void atualizarPedidoParaPronto(Long idDoPedido) {
        alterarStatusDoPedido(idDoPedido, StatusDoPedido.PRONTO);
    }

    public void atualizarPedidoParaFinalizado(Long idDoPedido) {
        alterarStatusDoPedido(idDoPedido, StatusDoPedido.FINALIZADO);
    }

    private void alterarStatusDoPedido(Long idDoPedido, StatusDoPedido finalizado) {
        Pedido pedido = pedidoRepository.findById(idDoPedido).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.atualizarStatusDoPedido(finalizado);
        pedidoRepository.save(pedido);
    }
}