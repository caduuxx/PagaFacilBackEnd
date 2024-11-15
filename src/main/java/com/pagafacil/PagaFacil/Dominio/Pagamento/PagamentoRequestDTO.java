package com.pagafacil.PagaFacil.Dominio.Pagamento;

import java.math.BigDecimal;

public record PagamentoRequestDTO(Long clienteId, String formaDePagamento, BigDecimal valorPagamento) {
}
