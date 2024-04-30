package com.fiap.challenge.service;

import com.fiap.challenge.domain.Cliente;
import com.fiap.challenge.domain.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public Cliente buscarCliente(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }

    @Transactional
    public Long incluirCLiente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO.getCpf(), clienteDTO.getNome(), clienteDTO.getEmail());
        clienteRepository.save(cliente);
        return cliente.getId();
    }
}