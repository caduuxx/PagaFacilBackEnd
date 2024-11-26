package com.pagafacil.PagaFacil.Dominio.Boleto;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletoService {

    private final BoletoRepositorty boletoRepository;

    public BoletoService(BoletoRepositorty boletoRepository) {
        this.boletoRepository = boletoRepository;
    }

    public List<Boleto> listarTodos() {
        return boletoRepository.findAll();
    }
}


