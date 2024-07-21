package com.fiap.challenge.domain.entities.excecao;

import java.util.ArrayList;
import java.util.List;

public class ExcecaoDeCampoObrigatorio extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final List<String> erros = new ArrayList<>();

    @Override
    public String getMessage() {
        return montarMensagemDeErro();
    }

    private String montarMensagemDeErro() {
        if (!erros.isEmpty()) {
            return String.join("\n", erros);
        }
        return "";
    }

    public ExcecaoDeCampoObrigatorio() {
    }

    private void inserir(String msg) {
        erros.add(msg);
    }

    private boolean possuiErro() {
        return !erros.isEmpty();
    }

    private ExcecaoDeCampoObrigatorio quando(boolean condicao, String mensagem) {
        if (condicao) {
            inserir(mensagem);
        }
        return this;
    }

    public ExcecaoDeCampoObrigatorio entaoDispara() throws ExcecaoDeCampoObrigatorio {
        if (!erros.isEmpty()) {
            String mensagemDeErro = "";
            for (String mensagem : erros) {
                mensagemDeErro = mensagemDeErro + " - " + mensagem;
            }
            throw this;
        }

        return this;
    }

    public ExcecaoDeCampoObrigatorio quandoNulo(Object obj, String mensagem) {
        quando(obj == null, mensagem);
        return this;
    }

    public ExcecaoDeCampoObrigatorio quandoVazio(String valor, String mensagem) {
        quandoNulo(valor, mensagem);
        if (!possuiErro()) {
            quando(valor.isEmpty(), mensagem);
        }
        return this;
    }

    public ExcecaoDeCampoObrigatorio quandoListaVazia(List<?> valor, String mensagem) {
        quandoNulo(valor, mensagem);
        if (!possuiErro()) {
            quando(valor.isEmpty(), mensagem);
        }
        return this;
    }
}
