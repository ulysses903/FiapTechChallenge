package com.fiap.challenge.domain.pedido.combo;

import com.fiap.challenge.domain.pedido.combo.produto.Acompanhamento;
import com.fiap.challenge.domain.pedido.combo.produto.Bebida;
import com.fiap.challenge.domain.pedido.combo.produto.Lanche;
import com.fiap.challenge.domain.pedido.combo.produto.Sobremesa;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Data
public class Combo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 19, scale = 2)
    private BigDecimal total;

    @ManyToOne
    private Lanche lanche;

    @ManyToOne
    private Acompanhamento acompanhamento;

    @ManyToOne
    private Bebida bebida;

    @ManyToOne
    private Sobremesa sobremesa;

    public Combo(Lanche lanche, Acompanhamento acompanhamento, Bebida bebida, Sobremesa sobremesa) {
        validarProdutos(lanche, acompanhamento, bebida, sobremesa);
        this.lanche = lanche;
        this.acompanhamento = acompanhamento;
        this.bebida = bebida;
        this.sobremesa = sobremesa;
        this.total = somarTotal(lanche, acompanhamento, bebida, sobremesa);
    }

    public Combo() {

    }

    private void validarProdutos(Lanche lanche, Acompanhamento acompanhamento, Bebida bebida, Sobremesa sobremesa) {
        if (lanche == null && acompanhamento == null && bebida == null && sobremesa == null) {
            throw new RuntimeException("Deve ser informado pelo menos um produto no combo.");
        }
    }

    private BigDecimal somarTotal(Lanche lanche, Acompanhamento acompanhamento, Bebida bebida, Sobremesa sobremesa) {
        BigDecimal total = BigDecimal.ZERO;
        total = lanche != null ? total.add(lanche.getPreco()) : total;
        total = acompanhamento != null ? total.add(acompanhamento.getPreco()) : total;
        total = bebida != null ? total.add(bebida.getPreco()) : total;
        total = sobremesa != null ? total.add(sobremesa.getPreco()) : total;
        if (total.equals(BigDecimal.ZERO)) {
            throw new RuntimeException("O combo deve possuir pelo menos um item.");
        }
        return total.setScale(2, RoundingMode.HALF_EVEN);
    }
}