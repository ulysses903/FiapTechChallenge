package com.fiap.challenge.repository.pagamento;

import com.fiap.challenge.domain.pedido.Pedido;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;

public interface PagamentoAPI {

    PagamentoDTO gerarPagamento(Pedido pedido) throws MPException, MPApiException;
}
