package com.fiap.challenge.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Data
public class Lanche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(precision = 19, scale = 2)
    private BigDecimal preco;

    public Lanche(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco.setScale(2, RoundingMode.HALF_EVEN);
    }

    public Lanche() {

    }
}