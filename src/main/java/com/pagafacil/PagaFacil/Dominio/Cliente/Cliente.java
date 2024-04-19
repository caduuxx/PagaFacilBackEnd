package com.pagafacil.PagaFacil.Dominio.Cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tb_cliente")
@Entity(name = "tb_cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String cnpj;
    private String nomeSocial;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;

    public Cliente(ClienteRequestDTO data){
        this.id = data.id();
        this.cpf = data.cpf();
        this.cnpj = data.cnpj();
        this.nomeSocial = data.nomeSocial();
        this.email = data.email();
        this.senha = data.senha();
        this.telefone = data.telefone();
        this.endereco = data.endereco();

    }

    public Long getId() {
        return this.id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getNomeSocial() {
        return this.nomeSocial;
    }
}