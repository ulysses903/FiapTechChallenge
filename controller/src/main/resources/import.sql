INSERT INTO cliente (nome, email, cpf) VALUES ('João2', 'joao@example.com', '19883297017');
INSERT INTO cliente (nome, email, cpf) VALUES ('Maria', 'maria@example.com', '54668294047');
INSERT INTO cliente (nome, email, cpf) VALUES ('Maria 1', 'maria1@example.com', '65320380089');

INSERT INTO produto (nome, preco, tipo) VALUES ('X-Tudo', '15.85', 'LANCHE');
INSERT INTO produto (nome, preco, tipo) VALUES ('Batata frita', '12.9', 'ACOMPANHAMENTO');
INSERT INTO produto (nome, preco, tipo) VALUES ('Suco de laranja', '12.9', 'BEBIDA');
INSERT INTO produto (nome, preco, tipo) VALUES ('Sorvete', '12.9', 'SOBREMESA');
INSERT INTO pedido (total, status_do_pedido, cliente_id) VALUES ('25.80', 'FINALIZADO', 2);
INSERT INTO combo (total, lanche_id, acompanhamento_id, bebida_id, sobremesa_id) VALUES ('25.80', 1, 2, 3, 4);
INSERT INTO pedido_combos (pedido_id, combos_id) VALUES (1, 1);