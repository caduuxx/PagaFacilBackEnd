package Domain.cliente;

public record ClienteRequestDTO(Long id, String cpf,String cnpj,String nomeSocial,
                                String email,String senha,String telefone,String endereco) {

}
