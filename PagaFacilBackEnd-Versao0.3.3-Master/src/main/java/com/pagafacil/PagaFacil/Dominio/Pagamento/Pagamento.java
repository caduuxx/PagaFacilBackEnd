package com.pagafacil.PagaFacil.Dominio.Pagamento;

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

    public Pagamento(PagamentoRequestDTO data){
        this.id = data.id();
        this.ValorPagamento = data.ValorPagamento();
        this.FormaDePagamento = data.FormaDePagamento();
    }

    public Pagamento(ClienteRequestDTO data) {
    }
}

