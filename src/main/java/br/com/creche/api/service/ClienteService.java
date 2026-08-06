package br.com.creche.api.service;

import br.com.creche.api.entity.Cliente;
import br.com.creche.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente){

        Optional<Cliente> clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
        if(clienteExistente.isPresent()){
            throw new RuntimeException("Este e-mail já está em uso na creche!");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id){
        clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));
        return clienteRepository.findById(id).get();
    }
}
