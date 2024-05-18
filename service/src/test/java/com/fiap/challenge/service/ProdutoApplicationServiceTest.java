package com.fiap.challenge.service;

import com.fiap.challenge.domain.Produto;
import com.fiap.challenge.domain.ProdutoRepository;
import com.fiap.challenge.domain.TipoDoProduto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = ConfiguracaoDeTesteParaCamadaDeServico.class)
class ProdutoApplicationServiceTest {

    @Autowired
    private ProdutoApplicationService produtoApplicationService;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    void deve_retornar_todos_os_produtos_do_tipo_lanche() {
        Produto produtoEsperado = new Produto("", BigDecimal.ONE, TipoDoProduto.LANCHE);
        Produto produtoNaoEsperado = new Produto("", BigDecimal.ONE, TipoDoProduto.BEBIDA);
        produtoRepository.saveAll(asList(produtoEsperado, produtoNaoEsperado));

        List<Produto> produtos = produtoApplicationService.listarLanches();

        assertThat(produtos).containsExactly(produtoEsperado);
    }
}