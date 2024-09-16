package com.pagafacil.PagaFacil.Dominio.Boleto;

import com.pagafacil.PagaFacil.Dominio.Boleto.Boleto;
import com.pagafacil.PagaFacil.Dominio.Boleto.BoletoRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletoService {

    @Autowired
    private BoletoRepositorty boletoRepository;

    public List<Boleto> listarTodos() {
        return boletoRepository.findAll();
    }
}

