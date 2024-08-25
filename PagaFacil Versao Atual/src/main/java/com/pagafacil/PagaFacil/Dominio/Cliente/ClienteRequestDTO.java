package com.pagafacil.PagaFacil.Dominio.Cliente;

public record ClienteRequestDTO(Long id, String cpf,String cnpj,String nomeSocial,
                                String email,String senha,int telefone,String endereco) {

}
