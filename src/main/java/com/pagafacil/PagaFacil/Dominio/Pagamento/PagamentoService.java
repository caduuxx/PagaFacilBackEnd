package com.pagafacil.PagaFacil.Dominio.Pagamento;

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

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BoletoRepositorty boletoRepository;

    public Pagamento cadastrarPagamento(Pagamento pagamentoDTO) {
        if (pagamentoDTO.getCliente() == null || pagamentoDTO.getBoleto() == null) {
            throw new IllegalArgumentException("ClienteId e BoletoId não podem ser nulos.");
        }

        Cliente cliente = clienteRepository.findById(pagamentoDTO.getCliente().getId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

        Boleto boleto = boletoRepository.findById(pagamentoDTO.getBoleto().getId())
                .orElseThrow(() -> new IllegalArgumentException("Boleto não encontrado."));

        Pagamento pagamento = new Pagamento();
        pagamento.setCliente(cliente);
        pagamento.setBoleto(boleto);
        pagamento.setValor(pagamentoDTO.getValor());
        pagamento.setDataPagamento(pagamentoDTO.getDataPagamento());

        return pagamentoRepository.save(pagamento);
    }
}
