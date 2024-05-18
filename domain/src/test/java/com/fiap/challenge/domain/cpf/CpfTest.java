package com.fiap.challenge.domain.cpf;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CpfTest {


    @Test
    void deve_criar_um_cpf_valido() throws CpfInvalido {
        String cpfValido = "868.841.342-83";

        Cpf cpf = new Cpf(cpfValido);

        assertThat(cpf.getValor()).isEqualTo(cpfValido);
    }

    @ParameterizedTest
    @ValueSource(strings = {"487", "111.111.111-11"})
    void nao_deve_aceitar_cpfs_invalidos(String cpf) throws CpfInvalido {
        Throwable throwable = catchThrowable(() -> new Cpf(cpf));

        assertThat(throwable).isInstanceOf(CpfInvalido.class);
    }

    @Test
    void nao_deve_aceitar_cpf_nulo() throws CpfInvalido {
        Throwable throwable = catchThrowable(() -> new Cpf(null));

        assertThat(throwable).isInstanceOf(CpfInvalido.class);
    }

    @Test
    void deve_comparar_se_dois_cpfs_sao_iguais() {
        String cpfValido = "355.220.808-92";
        Cpf cpf1 = new Cpf(cpfValido);

        Cpf cpf2 = new Cpf(cpfValido);

        assertThat(cpf2).isEqualTo(cpf1);
    }

    @Test
    void deve_remover_mascara_do_cpf() {
        String numero = "355.220.808-92";
        String numeroEsperado = "35522080892";
        Cpf cpf = new Cpf(numero);

        String valorSemMascara = cpf.getValorSemMascara();

        assertThat(valorSemMascara).isEqualTo(numeroEsperado);
    }

    @Test
    void deve_remover_espaco_do_numero_do_cpf() {
        String numeroComEspaco = " 316.88 4.20 6-06 ";
        String numeroEsperado = "316.884.206-06";

        Cpf cpf = new Cpf(numeroComEspaco);

        assertThat(cpf.getValor()).isEqualTo(numeroEsperado);
    }

    @ParameterizedTest
    @ValueSource(strings = {"35522080892", "355220808-92", "355.220.80892", "355.220.808-92"})
    void deve_armazenar_o_valor_com_a_mascara_do_cpf_sendo_criado_com_ou_sem_mascara(String numero) {
        String numeroFormatadoEsperado = "355.220.808-92";
        Cpf cpf = new Cpf(numero);

        String valorRetornado = cpf.getValor();

        assertThat(valorRetornado).isEqualTo(numeroFormatadoEsperado);
    }

    @Test
    void deve_retornar_o_valor_anonimizado() {
        String numero = "863.644.610-42";
        String numeroAnonimizado = "863.***.***-42";
        Cpf cpf = new Cpf(numero);

        String numeroRetornado = cpf.getValorMascaradoAnonimizado();

        assertThat(numeroRetornado).isEqualTo(numeroAnonimizado);
    }
}