package com.pagafacil.PagaFacil.Dominio.Pagamento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.pagafacil.PagaFacil.Dominio.Boleto.Boleto;
import com.pagafacil.PagaFacil.Dominio.Boleto.BoletoRepositorty;
import com.pagafacil.PagaFacil.Dominio.Cliente.Cliente;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

//    public Pagamento cadastrarPagamento(Pagamento pagamentoDTO) {
//        if (pagamentoDTO.getCliente() == null) {
//            throw new IllegalArgumentException("ClienteId não pode ser nulo.");
//        }
//        if (pagamentoDTO.getBoleto() == null) {
//            throw new IllegalArgumentException("BoletoId não pode ser nulo.");
//        }
//
//        Cliente cliente = clienteRepository.findById(pagamentoDTO.getCliente().getId())
//                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
//
//        Boleto boleto = boletoRepository.findById(pagamentoDTO.getBoleto().getId())
//                .orElseThrow(() -> new IllegalArgumentException("Boleto não encontrado."));
//
//        System.out.println("Cliente: " + pagamentoDTO.getCliente().getId());
//
//        Pagamento pagamento = new Pagamento();
//        pagamento.setCliente(cliente);
//        pagamento.setBoleto(boleto);
//        pagamento.setForma_de_pagamento(pagamentoDTO.getForma_de_pagamento());
//        pagamento.setValor_pagamento(pagamentoDTO.getValor_pagamento());
//        pagamento.setData_pagamento(pagamentoDTO.getData_pagamento());
//
//        return pagamentoRepository.save(pagamento);
//    }

}