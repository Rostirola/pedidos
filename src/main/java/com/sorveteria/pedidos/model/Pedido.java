package com.sorveteria.pedidos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long usuario;

    @NotNull
    private Long cliente;

    @NotNull
    private LocalDateTime dataHora ;

    @NotNull
    private BigDecimal valorTotal;

    @NotNull
    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="pedido")
    private List<PedidoItem> itens = new ArrayList<>();
}
