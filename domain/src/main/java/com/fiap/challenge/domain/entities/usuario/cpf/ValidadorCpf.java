package com.fiap.challenge.domain.entities.usuario.cpf;

public class ValidadorCpf {

    private static final int ONZE = 11;

    private static final int NOVE = 9;

    private static final int[] peso = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    public void validar(String cpf) {
        String cpfSemMascara = removerCaracteresEspeciais(cpf);
        validarSeCpfPossuiLetras(cpfSemMascara);
        validarAQuantidadeDeDigitos(cpfSemMascara);
        validarSequenciaDeDigitosRepetidos(cpfSemMascara);
        validarDigitosVerificadores(cpfSemMascara);
    }

    private String removerCaracteresEspeciais(String cpf) {
        return cpf.replace(".", "").replaceAll("-", "");
    }

    public void validarDigitosVerificadores(String cpf) throws CpfInvalido {
        Integer digito1 = calcularDigito(cpf.substring(0, NOVE));
        Integer digito2 = calcularDigito(cpf.substring(0, NOVE) + digito1);
        String cpfCalculado = cpf.substring(0, NOVE) + digito1.toString() + digito2.toString();

        if (!cpf.equals(cpfCalculado)) {
            throw new RuntimeException("O CPF " + cpf + " é inválido. Verifique se o número está correto e tente novamente.");
        }
    }

    private void validarSequenciaDeDigitosRepetidos(String cpf) throws CpfInvalido {
        if (cpf.matches("([0]{11}|[1]{11}|[2]{11}|[3]{11}|[4]{11}|[5]{11}|[6]{11}|[7]{11}|[8]{11}|[9]{11})")) {
            throw new CpfInvalido(cpf);
        }
    }

    private void validarAQuantidadeDeDigitos(String cpf) throws CpfInvalido {
        if (cpf.length() != ONZE) {
            throw new CpfInvalido(cpf);
        }
    }

    private void validarSeCpfPossuiLetras(String cpf) throws CpfInvalido {
        try {
            Long.parseLong(cpf);
        } catch (NumberFormatException e) {
            throw new CpfInvalido(cpf);
        }
    }

    private int calcularDigito(String str) {
        int soma = 0;
        int digito;
        for (int indice = str.length() - 1; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = ONZE - soma % ONZE;
        return soma > NOVE ? 0 : soma;
    }
}
