package com.fiap.challenge.core.usecases.pedido.combo.produto;

import com.fiap.challenge.core.entities.pedido.combo.produto.Acompanhamento;
import com.fiap.challenge.core.entities.pedido.combo.produto.AcompanhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AcompanhamentoApplicationService {
    private final AcompanhamentoRepository acompanhamentoRepository;

    @Autowired
    public AcompanhamentoApplicationService(AcompanhamentoRepository acompanhamentoRepository) {
        this.acompanhamentoRepository = acompanhamentoRepository;
    }

    public List<Acompanhamento> listarAcompanhamentos() {
        return acompanhamentoRepository.findAll();
    }

    public Acompanhamento buscarAcompanhamento(Long clienteId) {
        return acompanhamentoRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Acompanhamento não encontrado"));
    }

    @Transactional
    public void incluirAcompanhamento(AcompanhamentoDTO acompanhamentoDTO) {
        Acompanhamento cliente = new Acompanhamento(acompanhamentoDTO.getNome(), acompanhamentoDTO.getPreco());
        acompanhamentoRepository.save(cliente);
    }

    @Transactional
    public void atualizarAcompanhamento(Long idDoAcompanhamento, AcompanhamentoDTO acompanhamentoDTO) {
        Acompanhamento acompanhamento = acompanhamentoRepository.findById(idDoAcompanhamento).orElseThrow(() -> new RuntimeException("Acompanhamento não encontrado"));
        acompanhamento.atualizarProduto(acompanhamentoDTO.getNome(), acompanhamentoDTO.getPreco());
        acompanhamentoRepository.save(acompanhamento);
    }

    @Transactional
    public void deletarAcompanhamento(Long idDoAcompanhamento) {
        Acompanhamento acompanhamento = acompanhamentoRepository.findById(idDoAcompanhamento).orElseThrow(() -> new RuntimeException("Acompanhamento não encontrado"));
        acompanhamentoRepository.delete(acompanhamento);
    }
}