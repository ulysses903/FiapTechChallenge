package com.fiap.biblioteca;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}