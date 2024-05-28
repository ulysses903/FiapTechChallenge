package com.fiap.challenge.config;

import com.mercadopago.MercadoPagoConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ConfiguracaoMercadoPago {

    @Value( "${mercadopago.token}" )
    private String TOKEN_MERCADO_PAGO;

    @PostConstruct
    public void init() {
        MercadoPagoConfig.setAccessToken(TOKEN_MERCADO_PAGO);
    }
}
