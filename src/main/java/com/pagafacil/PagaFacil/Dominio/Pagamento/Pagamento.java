
package com.pagafacil.PagaFacil.Dominio.Pagamento;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


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

    private String forma_de_pagamento;
    private BigDecimal valor_pagamento;
    private Long cod_cliente;
//    @ManyToOne
//    @JoinColumn(name = "cliente_id", nullable = false)
//    private Cliente cliente;

//    @ManyToOne
//    @JoinColumn(name = "id", nullable = false)
//    private Boleto boleto;
    private Long cod_boleto;
    private Double valor;
    private LocalDate data_pagamento;



    // Construtor utilizando um DTO (PagamentoRequestDTO)
    public Pagamento(PagamentoRequestDTO data) {
        this.valor_pagamento = data.valor_pagamento();
        this.forma_de_pagamento = data.forma_de_pagamento();
        this.cod_cliente = data.cod_cliente();
        this.cod_boleto = data.cod_boleto();
        this.valor = data.valor();
        this.data_pagamento = data.data_pagamento();
    }

}