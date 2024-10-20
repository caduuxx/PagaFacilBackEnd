package com.pagafacil.PagaFacil.Dominio.Boleto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record BoletoResponseDTO(Long id, String nf_boleto, Double valor_boleto,
                                LocalDate vencimento_boleto, LocalDate data_emissao_boleto,
                                int cnpj_emissor, Date data_pagamento) {

    public BoletoResponseDTO(Boleto boleto){
        this(boleto.getId(), boleto.getNf_boleto(), boleto.getValor_boleto(),
                boleto.getVencimento_boleto(),boleto.getData_emissao_boleto(), boleto.getCnpj_emissor(),
                boleto.getData_pagamento());
    }
}
