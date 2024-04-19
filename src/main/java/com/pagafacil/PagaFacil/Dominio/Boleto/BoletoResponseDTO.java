package com.pagafacil.PagaFacil.Dominio.Boleto;

import java.util.Date;

public record BoletoResponseDTO(Long id, String nfboleto, String valor_boleto,
                                Date vencimento_boleto, Date data_emissao_boleto,
                                int cnpj_emissor, Date data_pagamento) {

    public BoletoResponseDTO(Boleto boleto){
        this(boleto.getId(), boleto.getNfboleto(), boleto.getValor_boleto(),
                boleto.getVencimento_boleto(),boleto.getData_emissao_boleto(), boleto.getCnpj_emissor(),
                boleto.getData_pagamento());
    }
}
