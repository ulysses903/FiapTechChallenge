package com.fiap.challenge.domain;


import java.math.BigDecimal;

public class ProdutoBuilder {

    private final String nome;
    private final BigDecimal preco;
    private final TipoDoProduto tipo;

    public ProdutoBuilder() {
        this.nome = "Teste";
        this.preco = new BigDecimal("10.50");
        this.tipo = TipoDoProduto.LANCHE;
    }

    public static ProdutoBuilder novo() {
        return new ProdutoBuilder();
    }

    public Produto criar() {
        return new Produto(nome, preco, tipo);
    }
}