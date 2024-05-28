package com.fiap.challenge.service.usuario;

import com.fiap.challenge.domain.usuario.Cliente;
import com.fiap.challenge.domain.usuario.ClienteRepository;
import com.fiap.challenge.domain.usuario.cpf.Cpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteApplicationService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteApplicationService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarCliente(String cpf) {
        Cpf cpfParaConsulta = new Cpf(cpf);
        return clienteRepository.findByCpf(cpfParaConsulta)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
    }

    @Transactional
    public Long incluirCLiente(ClienteDTO clienteDTO) {
        vailidarSeCpfJaExiste(clienteDTO);
        Cliente cliente = new Cliente(clienteDTO.getCpf(), clienteDTO.getNome(), clienteDTO.getEmail());
        clienteRepository.save(cliente);
        return cliente.getId();
    }

    private void vailidarSeCpfJaExiste(ClienteDTO clienteDTO) {
        Cpf cpfParaConsulta = new Cpf(clienteDTO.getCpf());
        Optional<Cliente> cpf = clienteRepository.findByCpf(cpfParaConsulta);
        if (cpf.isPresent()) {
            throw new RuntimeException("O CPF informado já existe.");
        }
    }
}