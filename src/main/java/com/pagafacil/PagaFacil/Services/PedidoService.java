package com.pagafacil.PagaFacil.Services;


import com.pagafacil.PagaFacil.Dominio.Pedido.Pedido;
import com.pagafacil.PagaFacil.Dominio.Pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido findById(Long id){
        Optional<Pedido> pedido = this.pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new RuntimeException(
                "pedido não encontrado ! Id : " + id + ", Tipo: " + Pedido.class.getName()
        ));
    }

    @Transactional
    public Pedido create(Pedido obj){
        obj.setId(null);
        obj = this.pedidoRepository.save(obj);
        return obj;
    }
    @Transactional
    public Pedido update (Pedido obj) {
        Pedido newObj = findById(obj.getId());
        newObj.setData_pedido(obj.getData_pedido());
        newObj.setNf_pedido(obj.getNf_pedido());
        return this.pedidoRepository.save(newObj);
    }
    @Transactional
    public void detele(Long id){
        findById(id);
        try {
            this.pedidoRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Nao e possivel excluir, pois ha entidades relacionadas ");
        }
    }
}
