package com.example.PagaFacil.controlle;

import Domain.cliente.Cliente;
import Domain.cliente.ClienteRepositorty;
import Domain.cliente.ClienteRequestDTO;
import Domain.cliente.ClienteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")

public class ClienteController {
    @Autowired
    private ClienteRepositorty repository;
    @PostMapping
    public void salvarCliente(@RequestBody ClienteRequestDTO data){
       Cliente clienteData = new Cliente(data);
        repository.save(clienteData);
        return;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    /* esse metodo puxa uma lista do banco de dados com todos os dados dos clientes porem nao e a melhor maneira de fazer
    e apenas um jeito de realizar testes */
    @GetMapping
    public List<ClienteResponseDTO> getAll(){
        List<ClienteResponseDTO> clienteList = repository.findAll().stream().map(ClienteResponseDTO::new).toList();
        return clienteList;
    }
}
