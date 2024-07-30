package com.fiap.challenge.core.usecases.pedido.combo.produto;

import com.fiap.challenge.core.entities.pedido.combo.produto.Sobremesa;
import com.fiap.challenge.core.entities.pedido.combo.produto.SobremesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SobremesaApplicationService {
    private final SobremesaRepository sobremesaRepository;

    @Autowired
    public SobremesaApplicationService(SobremesaRepository sobremesaRepository) {
        this.sobremesaRepository = sobremesaRepository;
    }

    public List<Sobremesa> listarSobremesas() {
        return sobremesaRepository.findAll();
    }

    public Sobremesa buscarSobremesa(Long clienteId) {
        return sobremesaRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Sobremesa não encontrado"));
    }

    @Transactional
    public void incluirSobremesa(SobremesaDTO sobremesaDTO) {
        Sobremesa cliente = new Sobremesa(sobremesaDTO.getNome(), sobremesaDTO.getPreco());
        sobremesaRepository.save(cliente);
    }

    @Transactional
    public void atualizarSobremesa(Long idDoSobremesa, SobremesaDTO sobremesaDTO) {
        Sobremesa sobremesa = sobremesaRepository.findById(idDoSobremesa).orElseThrow(() -> new RuntimeException("Sobremesa não encontrado"));
        sobremesa.atualizarProduto(sobremesaDTO.getNome(), sobremesaDTO.getPreco());
        sobremesaRepository.save(sobremesa);
    }

    @Transactional
    public void deletarSobremesa(Long idDoSobremesa) {
        Sobremesa sobremesa = sobremesaRepository.findById(idDoSobremesa).orElseThrow(() -> new RuntimeException("Sobremesa não encontrado"));
        sobremesaRepository.delete(sobremesa);
    }
}