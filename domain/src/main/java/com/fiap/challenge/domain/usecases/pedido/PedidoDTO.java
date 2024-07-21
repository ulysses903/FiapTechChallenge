package com.fiap.challenge.domain.usecases.pedido;

import com.fiap.challenge.domain.usecases.usuario.ClienteDTO;
import com.fiap.challenge.domain.usecases.pedido.combo.ComboDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private List<ComboDTO> combos;
    private ClienteDTO cliente;
}
