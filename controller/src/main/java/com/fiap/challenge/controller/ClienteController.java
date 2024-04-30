package com.fiap.challenge.controller;

import com.fiap.challenge.service.ClienteApplicationService;
import com.fiap.challenge.service.ClienteDTO;
import com.fiap.challenge.domain.Cliente;
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

    @PostMapping
    public ResponseEntity<Long> incluirCliente(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteApplicationService.incluirCLiente(clienteDTO));
    }
}