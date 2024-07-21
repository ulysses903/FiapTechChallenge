package com.fiap.challenge.core.entities.pedido.combo.produto;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("SOBREMESA")
public class Sobremesa extends Produto {

    public Sobremesa(String nome, BigDecimal preco) {
        super(nome, preco);
    }

    public Sobremesa() {

    }
}