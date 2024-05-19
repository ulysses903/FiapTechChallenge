package com.fiap.challenge.service;

import com.fiap.challenge.domain.StatusDoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private BigDecimal total;
    private StatusDoPedido status;
    private List<ComboDTO> combos;
    private ClienteDTO cliente;
}
