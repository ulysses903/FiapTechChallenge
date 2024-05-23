package com.fiap.challenge.service;

import com.fiap.challenge.domain.Lanche;
import com.fiap.challenge.domain.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LancheApplicationService {
    private final LancheRepository lancheRepository;

    @Autowired
    public LancheApplicationService(LancheRepository lancheRepository) {
        this.lancheRepository = lancheRepository;
    }

    public List<Lanche> listarLanches() {
        return lancheRepository.findAll();
    }

    public Lanche buscarLanche(Long lancheId) {
        return lancheRepository.findById(lancheId)
                .orElseThrow(() -> new IllegalArgumentException("Lanche não encontrado"));
    }

    @Transactional
    public void incluirLanche(LancheDTO lancheDTO) {
        Lanche lanche = new Lanche(lancheDTO.getNome(), lancheDTO.getPreco());
        lancheRepository.save(lanche);
    }

    @Transactional
    public void atualizarLanche(Long idDoLanche, LancheDTO lancheDTO) {
        Lanche lanche = lancheRepository.findById(idDoLanche).orElseThrow(() -> new RuntimeException("Lanche não encontrado"));
        lanche.atualizarProduto(lancheDTO.getNome(), lancheDTO.getPreco());
        lancheRepository.save(lanche);
    }

    @Transactional
    public void deletarLanche(Long idDoLanche) {
        Lanche lanche = lancheRepository.findById(idDoLanche).orElseThrow(() -> new RuntimeException("Lanche não encontrado"));
        lancheRepository.delete(lanche);
    }
}