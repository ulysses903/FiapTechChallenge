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

    public Lanche buscarLanche(Long clienteId) {
        return lancheRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Lanche não encontrado"));
    }

    @Transactional
    public Long incluirLanche(LancheDTO lancheDTO) {
        Lanche cliente = new Lanche(lancheDTO.getNome(), lancheDTO.getPreco());
        lancheRepository.save(cliente);
        return cliente.getId();
    }
}