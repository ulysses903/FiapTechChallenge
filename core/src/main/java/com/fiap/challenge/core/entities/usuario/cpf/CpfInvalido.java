package com.fiap.challenge.core.entities.usuario.cpf;

public class CpfInvalido extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CpfInvalido(String cpf) {
        super("O CPF " + cpf + " é inválido. Verifique se o número está correto e tente novamente.");
    }
}
