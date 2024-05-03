package com.fiap.challenge.service;

import com.fiap.challenge.domain.Cliente;
import com.fiap.challenge.domain.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = ConfiguracaoDeTesteParaCamadaDeServico.class)
class ClienteApplicationServiceTest {

    @Autowired
    private ClienteApplicationService clienteApplicationService;
    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void deve_incluir_um_cliente() {
        ClienteDTO clienteDTO = new ClienteDTO("1", "1", "1");

        Long idDoClienteAdicionado = clienteApplicationService.incluirCLiente(clienteDTO);

        Cliente clienteConsultadoPorId = clienteRepository.findById(idDoClienteAdicionado).orElse(null);
        assertThat(clienteConsultadoPorId).isNotNull();
    }
}