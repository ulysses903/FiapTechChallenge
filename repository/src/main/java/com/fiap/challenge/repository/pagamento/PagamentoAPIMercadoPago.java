package com.fiap.challenge.repository.pagamento;

import com.fiap.challenge.domain.pedido.Pedido;
import com.fiap.challenge.domain.pedido.combo.Combo;
import com.fiap.challenge.domain.pedido.combo.produto.Produto;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PagamentoAPIMercadoPago implements PagamentoAPI {

    @Override
    public PagamentoDTO gerarPagamento(Pedido pedido) throws MPException, MPApiException {
        MercadoPagoConfig.setAccessToken("TEST-5613929221812140-052612-38aa6c2199555785e373be8fa3b38a7e-178052576");

        PreferenceClient client = new PreferenceClient();

        List<PreferenceItemRequest> items = montarListaDeItens(pedido.getCombos());

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .backUrls(
                        PreferenceBackUrlsRequest.builder()
                                .success("http://localhost:8080/pedido/" + pedido.getId() + "/confirmarPagamento")
                                .failure("http://localhost:8080/pedido/" + pedido.getId() + "/cancelar")
                                .pending("http://localhost:8080/pedido/" + pedido.getId() + "/cancelar")
                                .build())
                .items(items)
                .expires(true)
                .autoReturn("all")
                .statementDescriptor("Lanchonete Tech Challenge")
                .build();
        
        Preference preference = client.create(preferenceRequest);
        return new PagamentoDTO(preference.getInitPoint(), preference.getId(), pedido.getId());
    }

    private List<PreferenceItemRequest> montarListaDeItens(List<Combo> combos) {
        List<PreferenceItemRequest> items = new ArrayList<>();
        combos.forEach(combo -> {
            criarItem(combo.getLanche(), items);
            criarItem(combo.getAcompanhamento(), items);
            criarItem(combo.getBebida(), items);
            criarItem(combo.getSobremesa(), items);
        });
        return items;
    }

    private void criarItem(Produto produto, List<PreferenceItemRequest> items) {
        if (produto != null) {
            PreferenceItemRequest itemLanche = montarItem(produto);
            items.add(itemLanche);
        }
    }

    private PreferenceItemRequest montarItem(Produto produto) {
        return PreferenceItemRequest.builder()
                .title(produto.getNome())
                .quantity(1)
                .currencyId("BRL")
                .unitPrice(produto.getPreco())
                .build();
    }
}
