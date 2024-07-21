package com.fiap.challenge.core.entities.pedido.combo.produto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BebidaRepository extends JpaRepository<Bebida, Long> {

}