package com.pagafacil.PagaFacil.Dominio.Pedido;

import java.util.Date;

public record PedidoResposeDTO(Long id, String nf_pedido, int cnpj_emissor, Double valor_total,
                               Date data_pedido, String nome_social_emissor) {

    public PedidoResposeDTO(Pedido pedido){
        this(pedido.getId(),pedido.getNf_pedido(), pedido.getCnpj_emissor(), pedido.getValor_total(),pedido.getData_pedido(),
                pedido.getNome_social_emissor());
    }

}
