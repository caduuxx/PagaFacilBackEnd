package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Pagamento.Pagamento;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoRequestDTO;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoResponseDTO;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<PagamentoResponseDTO> cadastrarPagamento(@RequestBody PagamentoRequestDTO data) {
        Pagamento pagamento = pagamentoService.cadastrarPagamento(data);
        return ResponseEntity.ok(new PagamentoResponseDTO(pagamento));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PagamentoResponseDTO>> listarPagamentos() {
        List<Pagamento> pagamentos = pagamentoService.listarPagamentos();
        List<PagamentoResponseDTO> response = pagamentos.stream()
                .map(PagamentoResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponseDTO> buscarPagamentoPorId(@PathVariable Long id) {
        Pagamento pagamento = pagamentoService.buscarPagamentoPorId(id);
        return ResponseEntity.ok(new PagamentoResponseDTO(pagamento));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarPagamento(@PathVariable Long id) {
        pagamentoService.deletarPagamento(id);
        return ResponseEntity.noContent().build();
    }
}
