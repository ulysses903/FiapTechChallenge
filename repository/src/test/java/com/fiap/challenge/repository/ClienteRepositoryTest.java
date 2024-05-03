package com.fiap.challenge.repository;

import com.fiap.challenge.domain.Cliente;
import com.fiap.challenge.domain.ClienteBuilder;
import com.fiap.challenge.domain.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = ConfiguracaoDeTesteParaCamadaDeRepositorio.class)
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void deve_incluir_cliente() {
        Cliente cliente = ClienteBuilder.novo().criar();

        clienteRepository.save(cliente);

        List<Cliente> clientes = clienteRepository.findAll();
        assertThat(clientes).containsExactly(cliente);
    }
}