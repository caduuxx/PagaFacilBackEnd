package com.pagafacil.PagaFacil.Dominio.Pedido;

import java.util.Date;

public record PedidoRequestDTO(Long id, String nf_pedido, int cnpj_emissor, Double valor_total,
                               Date data_pedido,String nome_social_emissor) {
}
