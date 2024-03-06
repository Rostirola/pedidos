package com.sorveteria.pedidos.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PedidoDto {

    private Long id;
    private Long usuario;
    private Long cliente;
    private String alimentos;
}
