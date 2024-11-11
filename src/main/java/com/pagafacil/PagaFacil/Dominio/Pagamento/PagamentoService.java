package com.pagafacil.PagaFacil.Dominio.Pagamento;

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

    public Pagamento cadastrarPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @Transactional
    public Pagamento cadastrarPagamento(PagamentoRequestDTO data) {
        // Verifica se o ID do cliente está presente
        assert data.getClienteId() != null;

        // Busca o cliente pelo ID
        Cliente cliente = clienteRepository.findById(data.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        // Cria o objeto Pagamento associando o cliente
        Pagamento pagamento = new Pagamento(data, cliente);

        // Atualiza o saldo do cliente
        cliente.setSaldo(cliente.getSaldo().add(data.getValorPagamento()));

        // Salva o pagamento no repositório
        return pagamentoRepository.save(pagamento);
    }


    public List<Pagamento> listarDepositos() {
        return pagamentoRepository.findAll(); // Retorna todos os pagamentos do repositório
    }


    public Pagamento buscarPagamentoPorId(Long id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado"));
    }

    public void deletarPagamento(Long id) {
        pagamentoRepository.deleteById(id);
    }
}
