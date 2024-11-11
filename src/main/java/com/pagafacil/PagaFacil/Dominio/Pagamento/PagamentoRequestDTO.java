package com.pagafacil.PagaFacil.Dominio.Pagamento;

import java.math.BigDecimal;

public record PagamentoRequestDTO(Long id, String FormaDePagamento, Double ValorPagamento) {

    public Long getClienteId() {
        return id; // Considerando que o id do cliente está sendo passado em "id"
    }

    public BigDecimal getValorPagamento() {
        return BigDecimal.valueOf(ValorPagamento); // Converter para BigDecimal
    }
}
