package com.fiap.challenge.service.pedido;

import com.fiap.challenge.domain.pedido.Pedido;
import com.fiap.challenge.domain.pedido.PedidoRepository;
import com.fiap.challenge.domain.pedido.StatusDoPedido;
import com.fiap.challenge.domain.pedido.combo.Combo;
import com.fiap.challenge.domain.usuario.Cliente;
import com.fiap.challenge.domain.usuario.ClienteRepository;
import com.fiap.challenge.repository.pagamento.PagamentoAPI;
import com.fiap.challenge.repository.pagamento.PagamentoDTO;
import com.fiap.challenge.service.pedido.combo.ComboApplicationService;
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
        if (combos.isEmpty()) {
            throw new RuntimeException("Pelo menos um produto deve ser informado para criar um pedido");
        }
        Cliente cliente = clienteRepository.findById(pedidoDTO.getCliente().getId()).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        Pedido pedido = new Pedido(combos, cliente);
        pedidoRepository.save(pedido);
        return pagamentoAPI.gerarPagamento(pedido);
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