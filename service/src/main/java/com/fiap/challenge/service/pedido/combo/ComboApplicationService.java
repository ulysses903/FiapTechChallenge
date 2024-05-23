package com.fiap.challenge.service.pedido.combo;

import com.fiap.challenge.domain.pedido.combo.*;
import com.fiap.challenge.domain.pedido.combo.produto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComboApplicationService {
    private final ComboRepository comboRepository;
    private final LancheRepository lancheRepository;
    private final AcompanhamentoRepository acompanhamentoRepository;
    private final BebidaRepository bebidaRepository;
    private final SobremesaRepository sobremesaRepository;

    public ComboApplicationService(ComboRepository comboRepository, LancheRepository lancheRepository,
                                   AcompanhamentoRepository acompanhamentoRepository, BebidaRepository bebidaRepository,
                                   SobremesaRepository sobremesaRepository) {
        this.comboRepository = comboRepository;
        this.lancheRepository = lancheRepository;
        this.acompanhamentoRepository = acompanhamentoRepository;
        this.bebidaRepository = bebidaRepository;
        this.sobremesaRepository = sobremesaRepository;
    }

    public List<Combo> adicionarCombos(List<ComboDTO> combosDto) {
        return combosDto.stream().map(comboDTO -> {
            Lanche lanche = buscarLanche(comboDTO);
            Acompanhamento acompanhamento = buscarAcompanhamento(comboDTO);
            Bebida bebida = buscarBebida(comboDTO);
            Sobremesa sobremesa = buscarSobremesa(comboDTO);
            Combo combo = new Combo(lanche, acompanhamento, bebida, sobremesa);
            comboRepository.save(combo);
            return combo;
        }).toList();
    }

    private Lanche buscarLanche(ComboDTO comboDTO) {
        if (comboDTO.getLanche() != null) {
            return lancheRepository.findById(comboDTO.getLanche().getId()).orElseThrow(() -> new RuntimeException("Lanche não encontrado"));
        }
        return null;
    }

    private Acompanhamento buscarAcompanhamento(ComboDTO comboDTO) {
        if (comboDTO.getAcompanhamento() != null) {
            return acompanhamentoRepository.findById(comboDTO.getAcompanhamento().getId()).orElseThrow(() -> new RuntimeException("Acompanhamento não encontrado"));
        }
        return null;
    }

    private Bebida buscarBebida(ComboDTO comboDTO) {
        if (comboDTO.getBebida() != null) {
            return bebidaRepository.findById(comboDTO.getBebida().getId()).orElseThrow(() -> new RuntimeException("Bebida não encontrado"));
        }
        return null;
    }

    private Sobremesa buscarSobremesa(ComboDTO comboDTO) {
        if (comboDTO.getSobremesa() != null) {
            return sobremesaRepository.findById(comboDTO.getSobremesa().getId()).orElseThrow(() -> new RuntimeException("Sobremesa não encontrado"));
        }
        return null;
    }
}