package com.fiap.challenge.domain.entities.pedido.combo.produto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LancheRepository extends JpaRepository<Lanche, Long> {

}