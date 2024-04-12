package com.sorveteria.pedidos.dto;

import com.sorveteria.pedidos.model.PedidoItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PedidoDto {

    private Long id;
    private Long usuario;
    private Long cliente;
    private LocalDateTime dataHora ;
    private BigDecimal valorTotal;
    private List<PedidoItemDto> itens;
}
