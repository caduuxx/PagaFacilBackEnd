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

    @Transactional
    public Pagamento cadastrarPagamento(PagamentoRequestDTO data) {

        // Busca o cliente pelo ID informado no request DTO
        Cliente cliente = clienteRepository.findById(data.clienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        // Cria uma nova instância de Pagamento, associando o cliente
        Pagamento pagamento = new Pagamento(data, cliente);

        if (pagamento.getId() == null || pagamento.getCliente().getId() == null) {
            throw new IllegalArgumentException("O ID do boleto e do cliente não podem ser nulos.");
        }

        // Salva o pagamento no banco de dados
        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);

        // Atualiza o saldo do cliente somente após a confirmação do pagamento salvo
        cliente.setSaldo(cliente.getSaldo().add(data.valorPagamento()));
        clienteRepository.save(cliente);

        return pagamentoSalvo;
    }


    public List<Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento buscarPagamentoPorId(Long id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado"));
    }

    public void deletarPagamento(Long id) {
        pagamentoRepository.deleteById(id);
    }
}
