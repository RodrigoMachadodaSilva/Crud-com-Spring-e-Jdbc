set foreign_key_checks = 0;

INSERT INTO pessoa (cpf, nome)
VALUES
  	('56637927082', 'Pessoa 1'),
  	('56637927082', 'Pessoa 2'),
  	('56637927089', 'Admir')
  	;

INSERT INTO produto (descricao, valor_unitario)
VALUES
  	('Produto 1', 10.0),
  	('Produto 2', 20.0),
  	('Produto 3', 20.0)
  	;
    
INSERT INTO produto (descricao, valor_unitario)
VALUES
  	('Produto 1', 10.0),
  	('Produto 2', 20.0),
  	('Produto 3', 20.0)
  	;
  	
INSERT INTO pedido_item (quantidade, pedido_id, preco_total, produto_id) 
values
	(12, 1, 120.00, 1),
    (7 ,2, 140.00, 2),
    (4, 2, 80.00, 3),
    (5, 3, 50.00, 1)
    ;


iNSERT INTO pedido (pessoa_id,pedido_item_id, valor_total)
 VALUES
	(1, 1, 120.00),
    (2, 2, 140.00),
    (3, 3, 50.00),
    (1, 4, 14.00)
    ;
  	
