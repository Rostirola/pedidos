CREATE TABLE item_do_pedido
(
    id          bigint(20)     NOT NULL AUTO_INCREMENT,
    quantidade  int(11)        NOT NULL,
    pedido   bigint(20)     NOT NULL,
    alimento bigint(20)     NOT NULL,
    valor_unitario       decimal(19, 2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (pedido) REFERENCES pedidos (id)
)
