package com.fiap.challenge.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 19, scale = 2)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private StatusDoPedido statusDoPedido;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Produto> produtos;

    @ManyToOne
    private Cliente cliente;

    public Pedido(BigDecimal total, List<Produto> produtos, Cliente cliente) {
        this.total = total.setScale(2, RoundingMode.HALF_EVEN);
        this.statusDoPedido = StatusDoPedido.RECEBIDO;
        this.produtos = produtos;
        this.cliente = cliente;
    }

    public Pedido() {

    }

    public void atualizarStatusDoPedido(StatusDoPedido statusDoPedido) {
        this.statusDoPedido = statusDoPedido;
    }
}