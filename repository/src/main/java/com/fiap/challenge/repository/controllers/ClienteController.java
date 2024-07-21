package com.fiap.challenge.repository.controllers;

import com.fiap.challenge.domain.entities.usuario.Cliente;
import com.fiap.challenge.domain.usecases.usuario.ClienteApplicationService;
import com.fiap.challenge.domain.usecases.usuario.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteApplicationService clienteApplicationService;

    @Autowired
    public ClienteController(ClienteApplicationService clienteApplicationService) {
        this.clienteApplicationService = clienteApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteApplicationService.listarClientes());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> buscarPorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(clienteApplicationService.buscarCliente(cpf));
    }

    @PostMapping
    public ResponseEntity<Long> incluirCliente(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteApplicationService.incluirCLiente(clienteDTO));
    }
}