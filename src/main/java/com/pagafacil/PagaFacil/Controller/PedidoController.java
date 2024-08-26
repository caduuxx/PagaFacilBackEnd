package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Pedido.Pedido;
import com.pagafacil.PagaFacil.Dominio.Pedido.PedidoRepository;
import com.pagafacil.PagaFacil.Dominio.Pedido.PedidoRequestDTO;
import com.pagafacil.PagaFacil.Dominio.Pedido.PedidoResposeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<PedidoResposeDTO> cadastrarPedido(@RequestBody PedidoRequestDTO data) {
        Pedido pedido = new Pedido(data);
        Pedido pedidoSalvo = repository.save(pedido);
        return ResponseEntity.ok(new PedidoResposeDTO(pedidoSalvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResposeDTO> buscarPedidoPorId(@PathVariable Long id) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
        return ResponseEntity.ok(new PedidoResposeDTO(pedido));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PedidoResposeDTO> atualizarPedido(@PathVariable Long id, @RequestBody PedidoRequestDTO data) {
        Pedido pedidoExistente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        pedidoExistente.setNf_pedido(data.nf_pedido());
        pedidoExistente.setCnpj_emissor(data.cnpj_emissor());
        pedidoExistente.setValor_total(data.valor_total());
        pedidoExistente.setData_pedido(data.data_pedido());
        pedidoExistente.setNome_social_emissor(data.nome_social_emissor());

        Pedido pedidoAtualizado = repository.save(pedidoExistente);

        return ResponseEntity.ok(new PedidoResposeDTO(pedidoAtualizado));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
        repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar")
    public List<PedidoResposeDTO> listarPedidos() {
        return repository.findAll().stream().map(PedidoResposeDTO::new).toList();
    }


}
