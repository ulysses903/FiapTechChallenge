package com.fiap.challenge.adapter.usuario;

import com.fiap.challenge.core.entities.usuario.Cliente;
import com.fiap.challenge.core.entities.usuario.ClienteBuilder;
import com.fiap.challenge.core.entities.usuario.ClienteRepository;
import com.fiap.challenge.adapter.ConfiguracaoDeTesteParaCamadaDeRepositorio;
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

    @Test
    void deve_buscar_cliente_por_cpf() {
        Cliente cliente = ClienteBuilder.novo().comCpf("12345678909").criar();
        clienteRepository.save(cliente);

        Cliente clienteRetornado = clienteRepository.findByCpf(cliente.getCpf()).orElse(null);

        assertThat(clienteRetornado).isEqualTo(cliente);
    }
}