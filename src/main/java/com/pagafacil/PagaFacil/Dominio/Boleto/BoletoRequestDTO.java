package com.pagafacil.PagaFacil.Dominio.Boleto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record BoletoRequestDTO (Long id, String nfboleto, BigDecimal valor_boleto,
                                LocalDate vencimento_boleto, LocalDateTime data_emissao_boleto,Long cnpj_emissor,
                                Date data_pagamento)  {

}
