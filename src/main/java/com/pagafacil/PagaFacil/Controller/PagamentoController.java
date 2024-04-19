package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Cliente.Cliente;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRepository;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRequestDTO;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteResposeDTO;
import com.pagafacil.PagaFacil.Dominio.Pagamento.Pagamento;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoRepository;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {
    @PostMapping
    public void salvarPagamentos(@RequestBody ClienteRequestDTO data){
        Pagamento pagamentoData = new Pagamento(data);
        repository.save(pagamentoData);
        return;
    }
    private PagamentoRepository repository;
    @GetMapping
    public List<PagamentoResponseDTO> getAll(){
        List<PagamentoResponseDTO> puxarDadosPagamento = repository.findAll().stream().map(PagamentoResponseDTO::new).toList();
        return puxarDadosPagamento;
    }

}
