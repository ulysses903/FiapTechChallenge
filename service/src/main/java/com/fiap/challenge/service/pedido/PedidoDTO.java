package com.fiap.challenge.service.pedido;

import com.fiap.challenge.domain.pedido.StatusDoPedido;
import com.fiap.challenge.service.usuario.ClienteDTO;
import com.fiap.challenge.service.pedido.combo.ComboDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private List<ComboDTO> combos;
    private ClienteDTO cliente;
}
