package com.fiap.challenge.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

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