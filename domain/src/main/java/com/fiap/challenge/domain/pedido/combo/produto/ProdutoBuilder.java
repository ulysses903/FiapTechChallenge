package com.fiap.challenge.domain.pedido.combo.produto;


import java.math.BigDecimal;

public class ProdutoBuilder {

    private final String nome;
    private final BigDecimal preco;

    public ProdutoBuilder() {
        this.nome = "Teste";
        this.preco = new BigDecimal("10.50");
    }

    public static ProdutoBuilder novo() {
        return new ProdutoBuilder();
    }
//
//    public Produto criar() {
//        return new Produto(nome, preco);
//    }
}