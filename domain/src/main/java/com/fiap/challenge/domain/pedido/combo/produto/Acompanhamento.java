package com.fiap.challenge.domain.pedido.combo.produto;

import com.fiap.challenge.domain.pedido.combo.produto.Produto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("ACOMPANHAMENTO")
public class Acompanhamento extends Produto {

    public Acompanhamento(String nome, BigDecimal preco) {
        super(nome, preco);
    }

    public Acompanhamento() {

    }
}