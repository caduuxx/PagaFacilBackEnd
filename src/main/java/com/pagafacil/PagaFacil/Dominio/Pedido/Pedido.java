package com.pagafacil.PagaFacil.Dominio.Pedido;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "tb_pedido")
@Entity(name = "tb_pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nf_pedido;
    private int cnpj_emissor;
    private Double valor_total;
    private Date data_pedido;
    private String nome_social_emissor;

    public Pedido(PedidoResposeDTO data){
        this.id = data.id();
        this.nf_pedido = data.nf_pedido();
        this.cnpj_emissor = data.cnpj_emissor();
        this.valor_total = data.valor_total();
        this.data_pedido = data.data_pedido();
        this.nome_social_emissor = data.nome_social_emissor();
    }
}
