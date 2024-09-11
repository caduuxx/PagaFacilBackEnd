package com.pagafacil.PagaFacil.Dominio.Boleto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record BoletoResponseDTO(Long id, String nfboleto, BigDecimal valor_boleto,
                                LocalDate vencimento_boleto, LocalDateTime data_emissao_boleto,
                                Long cnpj_emissor, Date data_pagamento) {

    public BoletoResponseDTO(Boleto boleto){
        this(boleto.getId(), boleto.getNfboleto(), boleto.getValor_boleto(),
                boleto.getVencimento_boleto(),boleto.getData_emissao_boleto(), boleto.getCnpj_emissor(),
                boleto.getData_pagamento());
    }
}
