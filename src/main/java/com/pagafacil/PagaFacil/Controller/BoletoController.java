package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Boleto.Boleto;
import com.pagafacil.PagaFacil.Dominio.Boleto.BoletoRepositorty;
import com.pagafacil.PagaFacil.Dominio.Boleto.BoletoRequestDTO;
import com.pagafacil.PagaFacil.Dominio.Boleto.BoletoResponseDTO;
import com.pagafacil.PagaFacil.Dominio.Cliente.Cliente;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRequestDTO;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteResposeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("boleto")
public class BoletoController {

    @Autowired
    private BoletoRepositorty repository; // Injeção de dependência

    //CRUD
    @PostMapping("/cadastrar")
    public ResponseEntity<BoletoResponseDTO> cadastrarBoleto(@RequestBody BoletoRequestDTO data) {
            Boleto boleto = new Boleto(data);
            repository.save(boleto); // Usando a instância injetada para salvar
         return ResponseEntity.ok(new BoletoResponseDTO(boleto));
    }



    @PutMapping("/atualizar/{id}")
    public ResponseEntity<BoletoResponseDTO> atualizarBoleto(@PathVariable Long id, @RequestBody BoletoRequestDTO data) {
        Boleto boletoExistente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Boleto não encontrado"));

        boletoExistente.setNfboleto(data.nf_boleto());
        boletoExistente.setValor_boleto(data.valor_boleto());
        boletoExistente.setVencimento_boleto(data.vencimento_boleto());
        boletoExistente.setData_emissao_boleto(data.data_emissao_boleto());
        boletoExistente.setCnpj_emissor(data.cnpj_emissor());
        boletoExistente.setData_pagamento(data.data_pagamento());

        repository.save(boletoExistente);

        return ResponseEntity.ok(new BoletoResponseDTO(boletoExistente));
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarBoleto(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // METODOS ADICIONAIS
    @PostMapping("/somar")
    public BoletoResponseDTO somarBoletos(@RequestBody List<Long> ids) {
        if (ids.size() < 2) {
            throw new IllegalArgumentException("Devem ser fornecidos pelo menos dois IDs de boletos para somar.");
        }

        List<Boleto> boletos = repository.findAllById(ids);

        double valorTotal = boletos.stream()
                .mapToDouble(boleto -> boleto.getValor_boleto())
                .sum();

        Boleto novoBoleto = new Boleto();
        novoBoleto.setValor_boleto(Double.valueOf(valorTotal));
        novoBoleto.setVencimento_boleto(LocalDate.now()); // Atualize conforme necessário
        novoBoleto.setData_emissao_boleto(LocalDate.now());
        novoBoleto.setCnpj_emissor(boletos.get(0).getCnpj_emissor());
        repository.save(novoBoleto);

        // ISSO VAI DA MERDA ! TEM QUE ARRUMAR, PQ NAO PODE DELETAR OS BOLETOS SO OCUTAR DO CLIENTE.
        // repository.deleteAll(boletos);

        return new BoletoResponseDTO(novoBoleto);
    }

    @GetMapping("/total")
    public String obterTotalAPagar() {
        double totalAPagar = repository.findAll()
                .stream()
                .mapToDouble(boleto -> boleto.getValor_boleto())
                .sum();

        return "Total a pagar: " + totalAPagar + " R$";
    }


}
