package com.pagafacil.PagaFacil.Dominio.Pagamento;

import com.pagafacil.PagaFacil.Dominio.Cliente.Cliente;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Table(name = "tb_pagamento")
@Entity(name = "tb_pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String formaDePagamento;
    private BigDecimal valorPagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Construtor utilizando um DTO (PagamentoRequestDTO)
    public Pagamento(PagamentoRequestDTO data, Cliente cliente) {
        this.id = data.clienteId();
        this.valorPagamento = data.valorPagamento();
        this.formaDePagamento = data.formaDePagamento();
        this.cliente = cliente;
    }
}


