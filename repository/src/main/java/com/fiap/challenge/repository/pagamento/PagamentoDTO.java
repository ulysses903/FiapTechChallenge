package com.fiap.challenge.repository.pagamento;

import com.mercadopago.resources.preference.Preference;
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
