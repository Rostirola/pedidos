CREATE TABLE pedidos
(
    id         bigint(20)     NOT NULL AUTO_INCREMENT,
    usuario    bigint(20)     NOT NULL,
    cliente    bigint(20)     NOT NULL,
    valor_total decimal(19, 2) NOT NULL,
    data_hora  datetime       NOT NULL,
    PRIMARY KEY (id)
);