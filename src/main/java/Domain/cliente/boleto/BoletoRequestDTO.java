package Domain.cliente.boleto;

import java.util.Date;

public record BoletoRequestDTO (Long id, String nfboleto, String valor_boleto,
                                Date vencimento_boleto,Date data_emissao_boleto,int cnpj_emissor,
                                Date data_pagamento)  {

}

