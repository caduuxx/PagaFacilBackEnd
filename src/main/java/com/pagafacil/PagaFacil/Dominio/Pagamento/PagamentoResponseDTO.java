
package com.pagafacil.PagaFacil.Dominio.Pagamento;

import java.math.BigDecimal;

public record PagamentoResponseDTO(Long id, String formaDePagamento, BigDecimal valorPagamento) {

    public PagamentoResponseDTO(Pagamento pagamento) {
        this(pagamento.getId(), pagamento.getFormaDePagamento(), pagamento.getValorPagamento());
    }
}
