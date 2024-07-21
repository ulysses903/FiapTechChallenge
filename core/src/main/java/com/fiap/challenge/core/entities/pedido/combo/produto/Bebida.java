package com.fiap.challenge.core.entities.pedido.combo.produto;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("BEBIDA")
public class Bebida extends Produto {

    public Bebida(String nome, BigDecimal preco) {
        super(nome, preco);
    }

    public Bebida() {

    }
}