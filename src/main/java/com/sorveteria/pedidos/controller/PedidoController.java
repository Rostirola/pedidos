package com.sorveteria.pedidos.controller;

import com.sorveteria.pedidos.dto.PedidoDto;
import com.sorveteria.pedidos.dto.PedidoItemDto;
import com.sorveteria.pedidos.service.PedidoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/Pedidos")
public class PedidoController {


    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public Page<PedidoDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return pedidoService.obterTodos(paginacao);
    };

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> detalhes(@PathVariable @NotNull Long id) {
        return ResponseEntity.ok(pedidoService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<PedidoDto> cadastrar(@RequestBody @Valid PedidoDto dto, UriComponentsBuilder uriBuilder) {
        PedidoDto pedido = pedidoService.criaPedido(dto);
        URI endereco = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();

        return ResponseEntity.created(endereco).body(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PedidoDto dto) {
        return ResponseEntity.ok(pedidoService.atualizaPedido(id, dto));
    }
}
