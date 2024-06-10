package com.pagafacil.PagaFacil.Services;

import com.pagafacil.PagaFacil.Dominio.Boleto.Boleto;
import com.pagafacil.PagaFacil.Dominio.Boleto.BoletoRepositorty;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRepository;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoRepository;
import com.pagafacil.PagaFacil.Dominio.Pedido.PedidoRepository;
import com.pagafacil.PagaFacil.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.management.RuntimeErrorException;
import java.util.Optional;

@Service
public class BoletoService {

    @Autowired
    private BoletoRepositorty boletoRepositorty;

    public Boleto findById(Long id){
        Optional<Boleto> boleto = this.boletoRepositorty.findById(id);
        return boleto.orElseThrow(() -> new RuntimeException(
                "Boleto não encontrado ! Id : " + id + ", Tipo: " + Boleto.class.getName()
        ));
    }

    @Transactional
    public Boleto create(Boleto obj){
        obj.setId(null);
        obj = this.boletoRepositorty.save(obj);
        return obj;
    }
    @Transactional
    public Boleto update (Boleto obj) {
        Boleto newObj = findById(obj.getId());
        newObj.setValor_boleto(obj.getValor_boleto());
        newObj.setVencimento_boleto(obj.getVencimento_boleto());
        return this.boletoRepositorty.save(newObj);
    }

    @Transactional
    public void detele(Long id){
        findById(id);
        try {
            this.boletoRepositorty.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Nao e possivel excluir, pois ha entidades relacionadas ");
        }
    }

}
