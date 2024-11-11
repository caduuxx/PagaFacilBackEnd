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
@RequestMapping("pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;  // Corrigido para injeção de dependência do serviço

    // CRUD

    @PostMapping("/cadastrar")
    public ResponseEntity<PagamentoResponseDTO> cadastrarPagamento(@RequestBody PagamentoRequestDTO data) {
        // Chama o serviço para cadastrar o pagamento, passando o DTO de solicitação
        Pagamento pagamento = pagamentoService.cadastrarPagamento(data);
        return ResponseEntity.ok(new PagamentoResponseDTO(pagamento)); // Retorna o DTO com os dados do pagamento
    }


    @GetMapping("/listar")
    public ResponseEntity<List<PagamentoResponseDTO>> listarDepositos() {
        // O método listarDepositos deve chamar o serviço e retornar a lista
        List<Pagamento> pagamentos = pagamentoService.listarDepositos();
        List<PagamentoResponseDTO> response = pagamentos.stream()
                .map(PagamentoResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response); // Retorna a lista de pagamentos como DTOs
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponseDTO> buscarDepositoPorId(@PathVariable Long id) {
        // Aqui buscamos o pagamento pelo ID com o serviço
        Pagamento pagamento = pagamentoService.buscarPagamentoPorId(id);
        return ResponseEntity.ok(new PagamentoResponseDTO(pagamento)); // Retorna o DTO com os dados do pagamento
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarDeposito(@PathVariable Long id) {
        // Aqui o serviço é chamado para deletar o pagamento
        pagamentoService.deletarPagamento(id);
        return ResponseEntity.noContent().build(); // Resposta com status 204 (sem conteúdo)
    }

    // Métodos adicionais podem ser implementados aqui, conforme a necessidade
}
