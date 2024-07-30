package com.fiap.challenge.core.usecases.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String cpf;
    private String nome;
    private String email;

    public ClienteDTO(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }
}
