package com.pagafacil.PagaFacil.Dominio.Cliente;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Calendar;

@Table(name = "tb_cliente")
@Entity(name = "tb_cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long id;
    private String cpf;
    private String cnpj;
    private String nomeSocial;
    private String email;
    private String senha;
    private int telefone;
    private String endereco;

    public Cliente(ClienteRequestDTO data){
        this.cpf = data.cpf();
        this.cnpj = data.cnpj();
        this.nomeSocial = data.nomeSocial();
        this.email = data.email();
        this.senha = data.senha();
        this.telefone = data.telefone();
        this.endereco = data.endereco();

    }

    private BigDecimal saldo;

    // Getter para o saldo
    public BigDecimal getSaldo() {
        return saldo;
    }

    // Setter para o saldo
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

}