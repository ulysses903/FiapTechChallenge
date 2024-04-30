package com.fiap.challenge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClienteTest {

    @Test
    void deve_ser_possivel_informar_o_nome_do_cliente() {
        String nomeEsperado = "Nome Esperado";

        Cliente cliente = ClienteBuilder.novo().comNome(nomeEsperado).criar();

        assertThat(cliente.getNome()).isEqualTo(nomeEsperado);
    }

    @Test
    void deve_ser_possivel_informar_o_email_do_cliente() {
        String emailEsperado = "emailEsperado@email.com";

        Cliente cliente = ClienteBuilder.novo().comEmail(emailEsperado).criar();

        assertThat(cliente.getEmail()).isEqualTo(emailEsperado);
    }

    @Test
    void deve_ser_possivel_informar_o_cpf_do_cliente() {
        String cpf = "728.750.350-61";

        Cliente cliente = ClienteBuilder.novo().comCpf(cpf).criar();

        assertThat(cliente.getCpf()).isEqualTo(cpf);
    }
}