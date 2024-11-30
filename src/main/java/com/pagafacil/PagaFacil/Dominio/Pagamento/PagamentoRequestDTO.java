
package com.pagafacil.PagaFacil.Dominio.Pagamento;


import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;


public record PagamentoRequestDTO(
         Long cod_cliente,
         String forma_de_pagamento,
         BigDecimal valor_pagamento,
         Long cod_boleto,
         Double valor,
         LocalDate data_pagamento


) {
}
