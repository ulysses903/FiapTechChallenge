package com.fiap.challenge.core.usuario;

import com.fiap.challenge.core.entities.excecao.ExcecaoDeCampoObrigatorio;
import com.fiap.challenge.core.entities.usuario.Cliente;
import com.fiap.challenge.core.entities.usuario.ClienteBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

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

        assertThat(cliente.getCpf().getValor()).isEqualTo(cpf);
    }

    @Test
    void deve_lancar_uma_excecao_se_o_cpf_nao_for_iformado() {
        Throwable throwable = catchThrowable(() -> ClienteBuilder.novo().comCpf("").criar());

        assertThat(throwable).isInstanceOf(ExcecaoDeCampoObrigatorio.class).hasMessage("O CPF é obrigatório.");
    }

    @Test
    void deve_lancar_uma_excecao_se_o_nome_nao_for_iformado() {
        Throwable throwable = catchThrowable(() -> ClienteBuilder.novo().comNome("").criar());

        assertThat(throwable).isInstanceOf(ExcecaoDeCampoObrigatorio.class).hasMessage("O nome é obrigatório.");
    }

    @Test
    void deve_lancar_uma_excecao_se_o_email_nao_for_iformado() {
        Throwable throwable = catchThrowable(() -> ClienteBuilder.novo().comEmail("").criar());

        assertThat(throwable).isInstanceOf(ExcecaoDeCampoObrigatorio.class).hasMessage("O email é obrigatório.");
    }
}