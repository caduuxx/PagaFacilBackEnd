
package com.pagafacil.PagaFacil.Dominio.Pagamento;


import java.math.BigDecimal;
import java.time.LocalDate;


public record PagamentoRequestDTO(
        Long clienteId,
        String formaDePagamento,
        BigDecimal valorPagamento,
        Long boletoId,
        Double valor,
        LocalDate dataPagamento


) {
}
