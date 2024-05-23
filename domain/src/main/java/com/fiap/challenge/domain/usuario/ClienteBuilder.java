package com.fiap.challenge.domain.usuario;


public class ClienteBuilder {

    private String cpf;
    private String nome;
    private String email;

    public ClienteBuilder() {
        this.cpf = "777.338.123-21";
        this.nome = "Wilson David Thiago da Silva";
        this.email = "email@email.com";
    }

    public static ClienteBuilder novo() {
        return new ClienteBuilder();
    }

    public ClienteBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder comEmail(String email) {
        this.email = email;
        return this;
    }

    public ClienteBuilder comCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Cliente criar() {
        return new Cliente(cpf, nome, email);
    }
}