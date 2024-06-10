package com.pagafacil.PagaFacil.Services;

import com.pagafacil.PagaFacil.Dominio.Boleto.Boleto;
import com.pagafacil.PagaFacil.Dominio.Boleto.BoletoRepositorty;
import com.pagafacil.PagaFacil.Dominio.Cliente.Cliente;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Long id){
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new RuntimeException(
                "Cliente não encontrado ! Id : " + id + ", Tipo: " + Cliente.class.getName()
        ));
    }

    @Transactional
    public Cliente create(Cliente obj){
        obj.setId(null);
        obj = this.clienteRepository.save(obj);
        return obj;
    }
    @Transactional
    public Cliente update (Cliente obj) {
        Cliente newObj = findById(obj.getId());
        newObj.setSenha(obj.getSenha());
        newObj.setTelefone(obj.getTelefone());
        return this.clienteRepository.save(newObj);
    }

    @Transactional
    public void detele(Long id){
        findById(id);
        try {
            this.clienteRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Nao e possivel excluir, pois ha entidades relacionadas ");
        }
    }
}
