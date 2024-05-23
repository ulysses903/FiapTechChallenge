package com.fiap.challenge.service.pedido.combo.produto;

import com.fiap.challenge.domain.pedido.combo.produto.Bebida;
import com.fiap.challenge.domain.pedido.combo.produto.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BebidaApplicationService {
    private final BebidaRepository bebidaRepository;

    @Autowired
    public BebidaApplicationService(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    public List<Bebida> listarBebidas() {
        return bebidaRepository.findAll();
    }

    public Bebida buscarBebida(Long clienteId) {
        return bebidaRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Bebida não encontrado"));
    }

    @Transactional
    public void incluirBebida(BebidaDTO bebidaDTO) {
        Bebida cliente = new Bebida(bebidaDTO.getNome(), bebidaDTO.getPreco());
        bebidaRepository.save(cliente);
    }

    @Transactional
    public void atualizarBebida(Long idDoBebida, BebidaDTO bebidaDTO) {
        Bebida bebida = bebidaRepository.findById(idDoBebida).orElseThrow(() -> new RuntimeException("Bebida não encontrado"));
        bebida.atualizarProduto(bebidaDTO.getNome(), bebidaDTO.getPreco());
        bebidaRepository.save(bebida);
    }

    @Transactional
    public void deletarBebida(Long idDoBebida) {
        Bebida bebida = bebidaRepository.findById(idDoBebida).orElseThrow(() -> new RuntimeException("Bebida não encontrado"));
        bebidaRepository.delete(bebida);
    }
}