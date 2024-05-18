package com.fiap.challenge.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LancheRepository extends JpaRepository<Lanche, Long> {

}