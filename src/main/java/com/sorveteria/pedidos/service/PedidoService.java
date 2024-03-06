package com.sorveteria.pedidos.service;

import com.sorveteria.pedidos.dto.PedidoDto;
import com.sorveteria.pedidos.model.Pedido;
import com.sorveteria.pedidos.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PedidoDto> obterTodos(Pageable paginacao) {
        return pedidoRepository.findAll(paginacao).map(p -> modelMapper.map(p, PedidoDto.class));
    }

    public PedidoDto obterPorId(Long id) {
        return modelMapper.map(pedidoRepository.findById(id).orElseThrow(EntityNotFoundException::new), PedidoDto.class);
    }

    public PedidoDto criaPedido(PedidoDto dto) {
        Pedido pedido = modelMapper.map(dto, Pedido.class);
        //set
        pedidoRepository.save(pedido);

        return modelMapper.map(pedido, PedidoDto.class);
    }

    public PedidoDto atualizaPedido(Long id, PedidoDto dto) {
        Pedido pedido = modelMapper.map(dto, Pedido.class);
        pedido.setId(id);
        pedido = pedidoRepository.save(pedido);
        return modelMapper.map(pedido, PedidoDto.class);
    }

    public void excluirPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
