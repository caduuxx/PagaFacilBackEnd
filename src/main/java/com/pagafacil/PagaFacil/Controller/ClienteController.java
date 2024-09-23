package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Cliente.Cliente;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRepository;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRequestDTO;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteResposeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {

    // Injeção de dependência do ClienteRepository
    @Autowired
    private ClienteRepository repository;

    //CRUD

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteResposeDTO> cadastrarCliente(@RequestBody ClienteRequestDTO data) {
        Cliente cliente = new Cliente(data);
        repository.save(cliente);
        return ResponseEntity.ok(new ClienteResposeDTO(cliente));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteResposeDTO>> listarClientes() {
        List<ClienteResposeDTO> clientes = repository.findAll().stream().map(ClienteResposeDTO::new).toList();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ClienteResposeDTO> buscarClientePorId(@PathVariable Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        return ResponseEntity.ok(new ClienteResposeDTO(cliente));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteResposeDTO> atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO data) {
        Cliente clienteExistente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        clienteExistente.setCnpj(data.cnpj());
        clienteExistente.setNomeSocial(data.nomeSocial());
        clienteExistente.setEmail(data.email());
        clienteExistente.setSenha(data.senha());
        clienteExistente.setTelefone(data.telefone());
        clienteExistente.setEndereco(data.endereco());

        repository.save(clienteExistente);

        return ResponseEntity.ok(new ClienteResposeDTO(clienteExistente));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        repository.delete(cliente);

        return ResponseEntity.noContent().build();
    }

    // Metodos Adicinais faltando
}
