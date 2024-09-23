package com.pagafacil.PagaFacil.Dominio.Cliente;

public record ClienteResposeDTO(Long id, String cnpj,String nomeSocial,
                                 String email,String senha,int telefone,String endereco) {

    public ClienteResposeDTO(Cliente cliente){
        this(cliente.getId(),cliente.getCnpj(), cliente.getNomeSocial(),
                cliente.getEmail(),cliente.getSenha(),cliente.getTelefone(),cliente.getEndereco());
    }

}
