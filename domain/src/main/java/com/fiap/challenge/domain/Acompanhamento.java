package com.fiap.challenge.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

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