package com.pagafacil.PagaFacil.Dominio.Boleto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoRepositorty extends JpaRepository<Boleto,Long> {
}