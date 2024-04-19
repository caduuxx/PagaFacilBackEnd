package com.pagafacil.PagaFacil.Dominio.Boleto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private String nfboleto;
    private String valor_boleto;
    private Date vencimento_boleto;
    private Date data_emissao_boleto;
    private int cnpj_emissor;
    private Date data_pagamento;

    public Boleto(BoletoRequestDTO data) {
        this.id = data.id();
        this.nfboleto = data.nfboleto();
        this.valor_boleto = data.valor_boleto();
        this.vencimento_boleto = data.vencimento_boleto();
        this.data_emissao_boleto = data.data_emissao_boleto();
        this.cnpj_emissor = data.cnpj_emissor();
        this.data_pagamento = data.data_pagamento();
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long setId) {
        this.id = setId;
    }

    public Date getData_pagamento() {
        return this.data_pagamento;
    }
    public void setData_pagamento(Long setDataPagamento) {
        this.id = setDataPagamento;
    }

    public String getNfboleto() {
        return this.nfboleto;
    }
    public void setNfboleto(Long setNfBoleto) {
        this.id = setNfBoleto;
    }

    public String getValor_boleto() {
        return this.valor_boleto;
    }
    public void setValor_boleto(Long setValorBoleto) {
        this.id = setValorBoleto;
    }

    public Date getVencimento_boleto() {
        return this.vencimento_boleto;
    }
    public void setVencimento_boleto(Long setVencimentoBoleto) {
        this.id = setVencimentoBoleto;
    }

    public Date getData_emissao_boleto() {
        return this.data_emissao_boleto;
    }
    public void setData_emissao_boleto(Long setDataEmissaoBoleto) {
        this.id = setDataEmissaoBoleto;
    }

    public int getCnpj_emissor() {
        return this.cnpj_emissor;
    }
    public void setCnpj_emissor(Long setCnpjEmissor) {
        this.id = setCnpjEmissor;
    }
}
