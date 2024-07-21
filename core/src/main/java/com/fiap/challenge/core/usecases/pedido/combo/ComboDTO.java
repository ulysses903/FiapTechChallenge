package com.fiap.challenge.core.usecases.pedido.combo;

import com.fiap.challenge.core.usecases.pedido.combo.produto.BebidaDTO;
import com.fiap.challenge.core.usecases.pedido.combo.produto.LancheDTO;
import com.fiap.challenge.core.usecases.pedido.combo.produto.SobremesaDTO;
import com.fiap.challenge.core.usecases.pedido.combo.produto.AcompanhamentoDTO;
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
