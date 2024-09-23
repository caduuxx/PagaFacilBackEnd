package com.pagafacil.PagaFacil.Dominio.Boleto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record BoletoRequestDTO (Long id, String nf_boleto, Double valor_boleto,
                                LocalDate vencimento_boleto, LocalDateTime data_emissao_boleto, int cnpj_emissor,
                                Date data_pagamento)  {

}
