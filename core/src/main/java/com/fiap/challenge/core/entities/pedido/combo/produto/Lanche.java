package com.fiap.challenge.core.entities.pedido.combo.produto;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("LANCHE")
public class Lanche extends Produto {

    public Lanche(String nome, BigDecimal preco) {
        super(nome, preco);
    }

    public Lanche() {

    }
}