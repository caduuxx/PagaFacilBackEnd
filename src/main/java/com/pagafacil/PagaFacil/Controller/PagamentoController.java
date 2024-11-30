package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Boleto.*;
import com.pagafacil.PagaFacil.Dominio.Pagamento.*;
import com.pagafacil.PagaFacil.Dominio.Pedido.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {
    private final PagamentoRepository repository;
    private final PagamentoService service;

    // Construtor para injeção de dependências
    @Autowired
    public PagamentoController(PagamentoRepository repository, PagamentoService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<PagamentoResponseDTO> cadastrarPagamento(@RequestBody PagamentoRequestDTO data) {
        Pagamento pagamento = new Pagamento(data);
        Pagamento pagamentoSalvo = repository.save(pagamento);
        return ResponseEntity.ok(new PagamentoResponseDTO(pagamentoSalvo));
    }
}
//    @PostMapping("/cadastrar")
//    public ResponseEntity<?> cadastrarPagamento(@RequestBody Pagamento pagamentoDTO) {
//        try {
//            Pagamento pagamento = pagamentoService.cadastrarPagamento(pagamentoDTO);
//            return ResponseEntity.ok(pagamento);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }