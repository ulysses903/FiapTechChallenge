package com.fiap.challenge.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComboDTO {

    private LancheDTO lanche;
    private AcompanhamentoDTO acompanhamento;
    private BebidaDTO bebida;
    private SobremesaDTO sobremesa;
}
