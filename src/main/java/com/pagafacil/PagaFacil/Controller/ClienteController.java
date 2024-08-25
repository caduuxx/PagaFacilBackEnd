package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Cliente.Cliente;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRepository;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRequestDTO;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteResposeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    // Injeção de dependência do ClienteRepository
    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public void salvarCliente(@RequestBody ClienteRequestDTO data){
        Cliente clienteData = new Cliente(data);
        repository.save(clienteData);
    }

    @GetMapping
    public List<ClienteResposeDTO> getAll(){
        List<ClienteResposeDTO> puxarDadosClientes = repository.findAll().stream().map(ClienteResposeDTO::new).toList();
        return puxarDadosClientes;
    }
}
