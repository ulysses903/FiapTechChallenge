package com.fiap.biblioteca;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private String cpf;
    private String nome;
    private String email;
}
