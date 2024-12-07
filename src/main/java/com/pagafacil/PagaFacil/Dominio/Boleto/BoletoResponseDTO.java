package com.pagafacil.PagaFacil.Dominio.Boleto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record BoletoResponseDTO(
        Long id,
        String nfboleto,
        BigDecimal valor_boleto,
        LocalDate vencimento_boleto,
        LocalDate data_emissao_boleto,
        String cnpj_emissor,
        Date data_pagamento,
        Long cnpj_cliente,
        Long pago
) {
    public BoletoResponseDTO(Boleto boleto) {
        this(
                boleto.getId(),
                boleto.getNfboleto(),
                boleto.getValor_boleto(),
                boleto.getVencimento_boleto(),
                boleto.getData_emissao_boleto(),
                boleto.getCnpj_emissor(),
                boleto.getData_pagamento(),
                boleto.getCnpj_cliente(),
                boleto.getPago()
        );
    }
}
