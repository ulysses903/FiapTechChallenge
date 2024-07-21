package com.fiap.challenge.domain.entities.pedido;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}