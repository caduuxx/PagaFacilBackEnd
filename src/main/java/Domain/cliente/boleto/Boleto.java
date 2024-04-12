package Domain.cliente.boleto;

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

}
