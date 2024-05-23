package com.fiap.challenge.service.pedido.combo;

import com.fiap.challenge.service.pedido.combo.produto.AcompanhamentoDTO;
import com.fiap.challenge.service.pedido.combo.produto.BebidaDTO;
import com.fiap.challenge.service.pedido.combo.produto.LancheDTO;
import com.fiap.challenge.service.pedido.combo.produto.SobremesaDTO;
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
