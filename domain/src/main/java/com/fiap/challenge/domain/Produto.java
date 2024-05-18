package com.fiap.challenge.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(precision = 19, scale = 2)
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private TipoDoProduto tipo;

    public Produto(String nome, BigDecimal preco, TipoDoProduto tipo) {
        this.nome = nome;
        this.preco = preco.setScale(2, RoundingMode.HALF_EVEN);
        this.tipo = tipo;
    }

    public Produto() {

    }

    public void atualizarProduto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco.setScale(2, RoundingMode.HALF_EVEN);
    }
}