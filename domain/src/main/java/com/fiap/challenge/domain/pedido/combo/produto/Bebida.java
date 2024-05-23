package com.fiap.challenge.domain.pedido.combo.produto;

import com.fiap.challenge.domain.pedido.combo.produto.Produto;
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