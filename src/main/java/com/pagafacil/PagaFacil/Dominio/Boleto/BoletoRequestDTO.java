package com.pagafacil.PagaFacil.Dominio.Boleto;

import java.util.Date;

public record BoletoRequestDTO (Long id, String nfboleto,String valor_total_boleto, String valor_boleto,
                                Date vencimento_boleto,Date data_emissao_boleto,int cnpj_emissor,
                                Date data_pagamento)  {

}
