package com.pagafacil.PagaFacil.Dominio.Boleto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

@Table(name = "tb_boleto")
@Entity(name = "tb_boleto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nf_boleto;
    private Double valor_boleto;
    private LocalDate vencimento_boleto;
    private LocalDate data_emissao_boleto;
    private int cnpj_emissor;
    private int cod_boleto;
    private Date data_pagamento;
    private int id_pedido;
    private int id_estado_boleto;

    public Boleto(BoletoRequestDTO data) {
        this.id = data.id();
        this.nf_boleto = data.nf_boleto();
        this.valor_boleto = data.valor_boleto();
        this.vencimento_boleto = data.vencimento_boleto();
        this.data_emissao_boleto = data.data_emissao_boleto();
        this.cnpj_emissor = data.cnpj_emissor();
        this.data_pagamento = data.data_pagamento();
        this.cod_boleto = data.cod_boleto();
    }

    public void setNfboleto(String nfboleto) {
    }

    public void setValor_boleto(Double s) {
    }

    public void setVencimento_boleto(LocalDate date) {
    }

    public void setData_emissao_boleto(LocalDate date) {
    }

    public void setCnpj_emissor(int i) {
    }

    public void setData_pagamento(Date date) {
    }
}
