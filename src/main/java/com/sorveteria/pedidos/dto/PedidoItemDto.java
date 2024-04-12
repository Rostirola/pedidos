package com.sorveteria.pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItemDto {

    private Long id;
    private Integer quantidade;
    private Long alimento;
    private BigDecimal valorUnitario;
}
