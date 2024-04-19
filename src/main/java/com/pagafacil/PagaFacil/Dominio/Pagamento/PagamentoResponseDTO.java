package com.pagafacil.PagaFacil.Dominio.Pagamento;

public record PagamentoResponseDTO(Long id,String FormaDePagamento,Double ValorPagamento) {

    public PagamentoResponseDTO(Pagamento pagamento){
        this(pagamento.getId(), pagamento.getFormaDePagamento(), pagamento.getValorPagamento());

    }

}
