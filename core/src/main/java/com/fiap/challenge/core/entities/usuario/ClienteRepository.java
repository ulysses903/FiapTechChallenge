package com.fiap.challenge.core.entities.usuario;


import com.fiap.challenge.core.entities.usuario.cpf.Cpf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(Cpf cpf);
}