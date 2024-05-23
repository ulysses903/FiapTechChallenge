package com.fiap.challenge.domain.pedido.combo.produto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AcompanhamentoRepository extends JpaRepository<Acompanhamento, Long> {

}