package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Boleto.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("boleto")
public class BoletoController {

    private final BoletoRepositorty repository;
    private final BoletoService service;

    // Construtor para injeção de dependências
    @Autowired
    public BoletoController(BoletoRepositorty repository, BoletoService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<BoletoResponseDTO> cadastrarBoleto(@Valid @RequestBody BoletoRequestDTO data) {
        Boleto boleto = new Boleto(data);
        repository.save(boleto);
        return ResponseEntity.ok(new BoletoResponseDTO(boleto));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<BoletoResponseDTO> atualizarBoleto(@PathVariable Long id, @RequestBody BoletoRequestDTO data) {
        Boleto boletoExistente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Boleto não encontrado"));

        boletoExistente.setNfboleto(data.nfboleto());
        boletoExistente.setValor_boleto(data.valor_boleto());
        boletoExistente.setVencimento_boleto(data.vencimento_boleto());
        boletoExistente.setData_emissao_boleto(data.data_emissao_boleto());
        boletoExistente.setCnpj_emissor(data.cnpj_emissor());
        boletoExistente.setData_pagamento(data.data_pagamento());
        boletoExistente.setCnpj_cliente(data.cnpj_cliente());
        boletoExistente.setPago(data.pago());


        repository.save(boletoExistente);
        return ResponseEntity.ok(new BoletoResponseDTO(boletoExistente));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarBoleto(@PathVariable Long id) {
        Boleto boleto = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Boleto não encontrado"));
        repository.delete(boleto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Boleto>> listarBoletos() {
        List<Boleto> boletos = service.listarTodos();
        return ResponseEntity.ok(boletos);
    }
}