package com.fiap.challenge.domain.pedido;

import com.fiap.challenge.domain.pedido.combo.Combo;
import com.fiap.challenge.domain.usuario.Cliente;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
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
    private List<Combo> combos;

    @ManyToOne
    private Cliente cliente;

    public Pedido(List<Combo> combos, Cliente cliente) {
        this.total = combos.stream().map(Combo::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        this.statusDoPedido = StatusDoPedido.RECEBIDO;
        this.combos = combos;
        this.cliente = cliente;
    }

    public Pedido() {

    }

    public void atualizarStatusDoPedido(StatusDoPedido statusDoPedido) {
        this.statusDoPedido = statusDoPedido;
    }
}