package com.pagafacil.PagaFacil.Dominio.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpfOrEmail(String cpf, String cnpj);
}
