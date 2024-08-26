package com.pagafacil.PagaFacil.Dominio.Pedido;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "tb_pedido")
@Entity(name = "tb_pedido")
@Getter
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

    public Pedido(PedidoRequestDTO data){
        this.id = data.id();
        this.nf_pedido = data.nf_pedido();
        this.cnpj_emissor = data.cnpj_emissor();
        this.valor_total = data.valor_total();
        this.data_pedido = data.data_pedido();
        this.nome_social_emissor = data.nome_social_emissor();
    }

    public void setNf_pedido(String s) {
    }

    public void setCnpj_emissor(int i) {
    }

    public void setValor_total(Double aDouble) {
    }

    public void setData_pedido(Date date) {
    }

    public void setNome_social_emissor(String s) {
    }
}
