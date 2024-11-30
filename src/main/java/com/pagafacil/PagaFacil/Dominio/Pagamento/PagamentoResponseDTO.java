
package com.pagafacil.PagaFacil.Dominio.Pagamento;

import java.math.BigDecimal;

public record PagamentoResponseDTO(Long id, String forma_de_pagamento, BigDecimal valor_pagamento, Long cod_boleto, Long cod_cliente) {

    public PagamentoResponseDTO(Pagamento pagamento) {
        this(pagamento.getId(), pagamento.getForma_de_pagamento(), pagamento.getValor_pagamento(), pagamento.getCod_boleto(), pagamento.getCod_cliente());
    }
}
