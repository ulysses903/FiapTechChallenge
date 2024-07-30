package com.fiap.challenge.core.gateway.pagamento;

import com.fiap.challenge.core.entities.pedido.PagamentoDTO;
import com.fiap.challenge.core.entities.pedido.Pedido;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;

public interface PagamentoAPI {

    PagamentoDTO gerarPagamento(Pedido pedido) throws MPException, MPApiException;
}
