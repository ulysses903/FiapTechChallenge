package com.fiap.challenge.domain;

import com.fiap.challenge.domain.cpf.Cpf;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @Embedded
    private Cpf cpf;

    public Cliente(String cpf, String nome, String email) {
        this.cpf = new Cpf(cpf);
        this.nome = nome;
        this.email = email;
    }

    public Cliente() {

    }
}