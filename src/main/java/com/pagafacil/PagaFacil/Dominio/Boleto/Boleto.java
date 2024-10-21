package com.pagafacil.PagaFacil.Dominio.Boleto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

@Table(name = "tb_boleto")
@Entity(name = "tb_boleto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nf_boleto")
    private String nfboleto;

    @Column(name = "valor_boleto")
    private BigDecimal valor_boleto;

    private LocalDate vencimento_boleto;

    private LocalDateTime data_emissao_boleto;

    private long cnpj_emissor;

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


}
