package com.pagafacil.PagaFacil.Dominio.Pagamento;

import com.pagafacil.PagaFacil.Dominio.Cliente.Cliente;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tb_pagamento")
@Entity(name = "tb_pagamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String FormaDePagamento;
    private Double ValorPagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Pagamento(PagamentoRequestDTO data){
        this.id = data.id();
        this.ValorPagamento = data.ValorPagamento();
        this.FormaDePagamento = data.FormaDePagamento();
    }
    //sets
    public Pagamento(ClienteRequestDTO data) {
    }

    public void setFormaDePagamento(String s) {
    }

    public void setValorPagamento(Double aDouble) {
    }
}

