package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Pagamento.Pagamento;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoRequestDTO;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoResponseDTO;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> cadastrarPagamento(@RequestBody Pagamento pagamentoDTO) {
        try {
            Pagamento pagamento = pagamentoService.cadastrarPagamento(pagamentoDTO);
            return ResponseEntity.ok(pagamento);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}



