package com.fiap.challenge.core.entities.pedido.combo.produto;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "categoria", discriminatorType = DiscriminatorType.STRING)
public abstract class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(precision = 19, scale = 2)
    private BigDecimal preco;

    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco.setScale(2, RoundingMode.HALF_EVEN);
    }

    public Produto() {

    }

    public void atualizarProduto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco.setScale(2, RoundingMode.HALF_EVEN);
    }
}