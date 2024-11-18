package com.pagafacil.PagaFacil.Dominio.Cliente;

public record ClienteRequestDTO(String cpf,String cnpj,String nomeSocial,
                                String email,String senha,int telefone,String endereco) {

}
