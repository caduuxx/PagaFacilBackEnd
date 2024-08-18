package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Pedido.Pedido;
import com.pagafacil.PagaFacil.Dominio.Pedido.PedidoRepository;
import com.pagafacil.PagaFacil.Dominio.Pedido.PedidoRequestDTO;
import com.pagafacil.PagaFacil.Dominio.Pedido.PedidoResposeDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {
    @PostMapping
    public void salvarPedido(@RequestBody PedidoRequestDTO data){
        Pedido pedidoData = new Pedido();
        repository.save(pedidoData);
        return;
    }
    private PedidoRepository repository;

    @GetMapping
    public List<PedidoResposeDTO> getAll(){
        List<PedidoResposeDTO> puxarPedidos = repository.findAll().stream().map(PedidoResposeDTO::new).toList();
        return puxarPedidos;
    }
}
