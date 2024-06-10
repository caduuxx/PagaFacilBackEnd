package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Boleto.Boleto;
import com.pagafacil.PagaFacil.Dominio.Cliente.Cliente;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRepository;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRequestDTO;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteResposeDTO;
import com.pagafacil.PagaFacil.Dominio.Pagamento.Pagamento;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoRepository;
import com.pagafacil.PagaFacil.Dominio.Pagamento.PagamentoResponseDTO;
import com.pagafacil.PagaFacil.Services.BoletoService;
import com.pagafacil.PagaFacil.Services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    //localhost:8080/pagamento/1 (ou o numero do id)
    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> findById(@PathVariable Long id){
        Pagamento obj = this.pagamentoService.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    @PostMapping
    public ResponseEntity<Void> create(Pagamento obj){
        this.pagamentoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Pagamento obj,@PathVariable Long id) {
        obj.setId(id);
        this.pagamentoService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.pagamentoService.detele(id);
        return ResponseEntity.noContent().build();
    }

}
