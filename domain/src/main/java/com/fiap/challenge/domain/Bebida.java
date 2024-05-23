package com.fiap.challenge.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

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