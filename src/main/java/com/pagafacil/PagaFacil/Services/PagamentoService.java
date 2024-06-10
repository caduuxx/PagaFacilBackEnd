package com.pagafacil.PagaFacil.Services;

import com.pagafacil.PagaFacil.Dominio.Cliente.Cliente;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRepository;
import com.pagafacil.PagaFacil.Dominio.Pagamento.Pagamento;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento findById(Long id){
        Optional<Pagamento> pagamento = this.pagamentoRepository.findById(id);
        return pagamento.orElseThrow(() -> new RuntimeException(
                "pagamento não encontrado ! Id : " + id + ", Tipo: " + Pagamento.class.getName()
        ));
    }

    @Transactional
    public Pagamento create(Pagamento obj){
        obj.setId(null);
        obj = this.pagamentoRepository.save(obj);
        return obj;
    }
    @Transactional
    public Pagamento update (Pagamento obj) {
        Pagamento newObj = findById(obj.getId());
        newObj.setValorPagamento(obj.getValorPagamento());
        return this.pagamentoRepository.save(newObj);
    }

    @Transactional
    public void detele(Long id){
        findById(id);
        try {
            this.pagamentoRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Nao e possivel excluir, pois ha entidades relacionadas ");
        }
    }
}
