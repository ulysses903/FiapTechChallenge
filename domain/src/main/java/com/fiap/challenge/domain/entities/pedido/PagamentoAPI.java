package com.fiap.challenge.domain.entities.pedido;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;

public interface PagamentoAPI {

    PagamentoDTO gerarPagamento(Pedido pedido) throws MPException, MPApiException;
}
