package com.fiap.challenge.service;

import com.fiap.challenge.domain.TipoDoProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private BigDecimal preco;

}
