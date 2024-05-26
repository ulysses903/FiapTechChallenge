package com.fiap.challenge.domain.usuario;

import com.fiap.challenge.domain.excecao.ExcecaoDeCampoObrigatorio;
import com.fiap.challenge.domain.usuario.cpf.Cpf;
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
        validarCamposObrigatorios(cpf, nome, email);
        this.cpf = new Cpf(cpf);
        this.nome = nome;
        this.email = email;
    }

    public Cliente() {

    }

    private void validarCamposObrigatorios(String cpf, String nome, String email) {
        new ExcecaoDeCampoObrigatorio()
                .quandoVazio(cpf, "O CPF é obrigatório.")
                .quandoVazio(nome, "O nome é obrigatório.")
                .quandoVazio(email, "O email é obrigatório.")
                .entaoDispara();
    }
}