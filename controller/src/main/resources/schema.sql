# CREATE TABLE cliente (
#     id BIGINT AUTO_INCREMENT PRIMARY KEY,
#     nome VARCHAR(255) NOT NULL,
#     cpf VARCHAR(255) NOT NULL,
#     email VARCHAR(255) NOT NULL
# );
#
# CREATE TABLE produto (
#     id BIGINT AUTO_INCREMENT PRIMARY KEY,
#     nome VARCHAR(255) NOT NULL,
#     preco DECIMAL(10, 2) NOT NULL,
#     tipo ENUM('LANCHE', 'ACOMPANHAMENTO', 'BEBIDA', 'SOBREMESA') NOT NULL
# );
#
# CREATE TABLE pedido (
#     id BIGINT AUTO_INCREMENT PRIMARY KEY,
#     total DECIMAL(10, 2) NOT NULL,
#     status_do_pedido ENUM('PENDENTE', 'FINALIZADO', 'CANCELADO') NOT NULL,
#     cliente_id BIGINT,
#     FOREIGN KEY (cliente_id) REFERENCES cliente(id)
# );
#
# CREATE TABLE combo (
#     id BIGINT AUTO_INCREMENT PRIMARY KEY,
#     total DECIMAL(10, 2) NOT NULL,
#     lanche_id BIGINT,
#     acompanhamento_id BIGINT,
#     bebida_id BIGINT,
#     sobremesa_id BIGINT,
#     FOREIGN KEY (lanche_id) REFERENCES produto(id),
#     FOREIGN KEY (acompanhamento_id) REFERENCES produto(id),
#     FOREIGN KEY (bebida_id) REFERENCES produto(id),
#     FOREIGN KEY (sobremesa_id) REFERENCES produto(id)
# );
#
# CREATE TABLE pedido_combos (
#     pedido_id BIGINT,
#     combos_id BIGINT,
#     PRIMARY KEY (pedido_id, combos_id),
#     FOREIGN KEY (pedido_id) REFERENCES pedido(id),
#     FOREIGN KEY (combos_id) REFERENCES combo(id)
# );
