package br.com.creche.api.controller;

import br.com.creche.api.entity.Cliente;
import br.com.creche.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")

public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente){

        Cliente clienteSalvo = clienteService.cadastrarCliente(cliente);
        return
                ResponseEntity.status(201).body(clienteSalvo);

    }

}

