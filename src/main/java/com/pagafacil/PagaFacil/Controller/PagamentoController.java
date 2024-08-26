package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Cliente.Cliente;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRepository;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRequestDTO;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteResposeDTO;
import com.pagafacil.PagaFacil.Dominio.Pagamento.Pagamento;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoRepository;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoRequestDTO;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;

    //CRUD
    @PostMapping("/cadastrar")
    public ResponseEntity<PagamentoResponseDTO> cadastrarPagamento(@RequestBody PagamentoRequestDTO data) {
        Pagamento pagamento = new Pagamento(data);
        Pagamento pagamentoSalvo = repository.save(pagamento);
        return ResponseEntity.ok(new PagamentoResponseDTO(pagamentoSalvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponseDTO> buscarPagamentoPorId(@PathVariable Long id) {
        Pagamento pagamento = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado"));
        return ResponseEntity.ok(new PagamentoResponseDTO(pagamento));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PagamentoResponseDTO> atualizarPagamento(@PathVariable Long id, @RequestBody PagamentoRequestDTO data) {
        Pagamento pagamentoExistente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado"));

        pagamentoExistente.setFormaDePagamento(data.FormaDePagamento());
        pagamentoExistente.setValorPagamento(data.ValorPagamento());

        Pagamento pagamentoAtualizado = repository.save(pagamentoExistente);

        return ResponseEntity.ok(new PagamentoResponseDTO(pagamentoAtualizado));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarPagamento(@PathVariable Long id) {
        Pagamento pagamento = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado"));
        repository.delete(pagamento);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar")
    public List<PagamentoResponseDTO> listarPagamentos() {
        return repository.findAll().stream().map(PagamentoResponseDTO::new).toList();
    }


    //Metodos Adicionais Faltando

}
