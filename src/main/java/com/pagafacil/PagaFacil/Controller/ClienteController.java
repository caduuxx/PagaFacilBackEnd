package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Cliente.Cliente;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRepository;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRequestDTO;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteResposeDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    //public String FalaSeDeuCerto(){
      // String deucerto = "Deu Certo";
      // return deucerto;
    //}

    @PostMapping
    public void salvarCliente(@RequestBody ClienteRequestDTO data){
        Cliente clienteData = new Cliente(data);
        repository.save(clienteData);
        return;
    }
    private ClienteRepository repository;
    @GetMapping
    public List<ClienteResposeDTO> getAll(){
       List<ClienteResposeDTO> puxarDadosClientes = repository.findAll().stream().map(ClienteResposeDTO::new).toList();
       return puxarDadosClientes;
    }
}
