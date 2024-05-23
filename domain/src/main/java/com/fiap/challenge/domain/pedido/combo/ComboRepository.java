package com.fiap.challenge.domain.pedido.combo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ComboRepository extends JpaRepository<Combo, Long> {

}