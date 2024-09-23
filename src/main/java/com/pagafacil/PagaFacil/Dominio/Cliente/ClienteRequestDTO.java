package com.pagafacil.PagaFacil.Dominio.Cliente;

public record ClienteRequestDTO(Long id, String cnpj,String nomeSocial,
                                String email,String senha,int telefone,String endereco) {

}
