package com.fiap.challenge.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findAllByTipo(TipoDoProduto tipoDoProduto);
}