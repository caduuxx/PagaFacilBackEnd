package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Boleto.Boleto;
import com.pagafacil.PagaFacil.Dominio.Pedido.Pedido;
import com.pagafacil.PagaFacil.Dominio.Pedido.PedidoRepository;
import com.pagafacil.PagaFacil.Dominio.Pedido.PedidoRequestDTO;
import com.pagafacil.PagaFacil.Dominio.Pedido.PedidoResposeDTO;
import com.pagafacil.PagaFacil.Services.BoletoService;
import com.pagafacil.PagaFacil.Services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    //localhost:8080/pedido/1 (ou o numero do id)
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Pedido obj = this.pedidoService.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    @PostMapping
    public ResponseEntity<Void> create(Pedido obj){
        this.pedidoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Pedido obj,@PathVariable Long id) {
        obj.setId(id);
        this.pedidoService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.pedidoService.detele(id);
        return ResponseEntity.noContent().build();
    }
}
