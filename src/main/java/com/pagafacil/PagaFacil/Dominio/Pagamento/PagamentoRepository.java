package com.pagafacil.PagaFacil.Dominio.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    // O método save já é fornecido pelo JpaRepository, não precisa de uma consulta customizada
    // Pagamento save(Pagamento pagamento);
}