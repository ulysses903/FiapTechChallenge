package com.fiap.challenge.domain.usecases.pedido;

import com.fiap.challenge.domain.entities.pedido.*;
import com.fiap.challenge.domain.entities.pedido.combo.Combo;
import com.fiap.challenge.domain.entities.usuario.Cliente;
import com.fiap.challenge.domain.entities.usuario.ClienteRepository;
import com.fiap.challenge.domain.usecases.pedido.combo.ComboApplicationService;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoApplicationService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ComboApplicationService comboApplicationService;
    private final PagamentoAPI pagamentoAPI;

    @Autowired
    public PedidoApplicationService(PedidoRepository pedidoRepository,
                                    ClienteRepository clienteRepository,
                                    ComboApplicationService comboApplicationService,
                                    PagamentoAPI pagamentoAPI) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.comboApplicationService = comboApplicationService;
        this.pagamentoAPI = pagamentoAPI;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPedido(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
    }

    @Transactional
    public PagamentoDTO incluirPedido(PedidoDTO pedidoDTO) throws MPException, MPApiException {
        List<Combo> combos = comboApplicationService.adicionarCombos(pedidoDTO.getCombos());
        Cliente cliente = buscarCliente(pedidoDTO);
        Pedido pedido = new Pedido(combos, cliente);
        pedidoRepository.save(pedido);
        return pagamentoAPI.gerarPagamento(pedido);
    }

    private Cliente buscarCliente(PedidoDTO pedidoDTO) {
        if (pedidoDTO.getCliente() != null && pedidoDTO.getCliente().getId() != null) {
            return clienteRepository.findById(pedidoDTO.getCliente().getId()).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        }
        return null;
    }

    @Transactional
    public void deletarPedido(Long idDoPedido) {
        Pedido pedido = pedidoRepository.findById(idDoPedido).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedidoRepository.delete(pedido);
    }

    public void atualizarPedidoParaRecebido(Long idDoPedido) {
        alterarStatusDoPedido(idDoPedido, StatusDoPedido.RECEBIDO);
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