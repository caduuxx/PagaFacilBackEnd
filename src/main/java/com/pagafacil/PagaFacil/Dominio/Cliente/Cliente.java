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
    private String cnpj;
    private String nomeSocial;
    private String email;
    private String senha;
    private int telefone;
    private String endereco;

    public Cliente(ClienteRequestDTO data){
        this.cnpj = data.cnpj();
        this.nomeSocial = data.nomeSocial();
        this.email = data.email();
        this.senha = data.senha();
        this.telefone = data.telefone();
        this.endereco = data.endereco();

    }

    //Sets

    public void setCnpj(String cnpj) {
    }

    public void setNomeSocial(String s) {
    }

    public void setEmail(String email) {
    }

    public void setSenha(String senha) {
    }

    public void setTelefone(int telefone) {
    }

    public void setEndereco(String endereco) {
    }


}