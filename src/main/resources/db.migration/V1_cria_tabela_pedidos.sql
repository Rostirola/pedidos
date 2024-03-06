CREATE TABLE pedidos
(
    id        bigint(20) NOT NULL AUTO_INCREMENT,
    usuario   bigint(20)   NOT NULL,
    cliente   bigint(20) NOT NULL,
    alimentos varchar(255) NOT NULL,
    PRIMARY KEY (id)
);