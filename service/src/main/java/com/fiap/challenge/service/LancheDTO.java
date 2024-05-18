package com.fiap.challenge.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LancheDTO {

    private String nome;
    private BigDecimal preco;

}
