package com.fiap.challenge.core.entities.usuario.cpf;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class Cpf implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cpf = "";

    @SuppressWarnings("unused")
    protected Cpf() {
    }

    public Cpf(String cpf) {
        validarCampoObrigatorio(cpf);
        cpf = formatar(cpf);
        validar(cpf);
        this.cpf = cpf;
    }

    public static String formatar(String cpf) {
        String cpfSemMascara = removerMascara(cpf);
        return cpfSemMascara.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    private static void validar(String cpf) {
        new ValidadorCpf().validar(cpf);
    }

    private static void validarCampoObrigatorio(String cpf) {
        if (cpf == null) {
            throw new CpfInvalido(cpf);
        }
    }

    public String getValor() {
        return this.cpf;
    }

    public String getValorSemMascara() {
        return removerMascara(this.cpf);
    }

    private static String removerMascara(String cpf) {
        return cpf.replaceAll("[^\\d]", "");
    }

    public String getValorMascaradoAnonimizado() {
        return getValor().replaceAll("(\\d{3}).(\\d{3}).(\\d{3})-(\\d{2})", "$1.***.***-$4");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cpf)) {
            return false;
        }
        Cpf outro = (Cpf) o;
        return this.cpf.equals(outro.cpf);
    }

    @Override
    public int hashCode() {
        return this.cpf.hashCode();
    }
}
