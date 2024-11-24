package com.pagafacil.PagaFacil.Dominio.Pagamento;

import com.pagafacil.PagaFacil.Dominio.Boleto.Boleto;
import com.pagafacil.PagaFacil.Dominio.Boleto.BoletoRepositorty;
import com.pagafacil.PagaFacil.Dominio.Cliente.Cliente;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BoletoRepositorty boletoRepository;

    public Pagamento cadastrarPagamento(Pagamento pagamentoDTO) {
        if (pagamentoDTO.getCliente() == null || pagamentoDTO.getBoleto() == null) {
            throw new IllegalArgumentException("Cliente e Boleto não podem ser nulos.");
        }

        Long clienteId = pagamentoDTO.getCliente().getId();
        Long boletoId = pagamentoDTO.getBoleto().getId();

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

        Boleto boleto = boletoRepository.findById(boletoId)
                .orElseThrow(() -> new IllegalArgumentException("Boleto não encontrado."));

        Pagamento pagamento = new Pagamento();
        pagamento.setCliente(cliente);
        pagamento.setBoleto(boleto);
        pagamento.setValor(pagamentoDTO.getValor());
        pagamento.setDataPagamento(pagamentoDTO.getDataPagamento());

        return pagamentoRepository.save(pagamento);
    }
}

