package com.fiap.challenge.core.entities.pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {

    private String urlDePagamento;
    private String idDoPagamento;
    private Long idDoPedido;
}
