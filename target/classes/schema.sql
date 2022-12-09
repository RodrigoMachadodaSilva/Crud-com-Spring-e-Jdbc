CREATE TABLE pessoa (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  cpf VARCHAR(11) NOT NULL,
  nome VARCHAR(250) NOT NULL
);

CREATE TABLE produto (
  registro INT AUTO_INCREMENT  PRIMARY KEY,
  descricao VARCHAR(50) NOT NULL,
  valor_unitario NUMERIC(10,2) NOT NULL
);

CREATE TABLE pedido_item (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  quantidade int  NOT NULL,
  produto_id int not null,
  preco_total NUMERIC(10,2),
  pedido_id int not null
  
); 

CREATE TABLE pedido (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  pessoa_id int not null,
  pedido_item_id int not null,
  valor_total NUMERIC(10,2) NOT NULL
);

ALTER TABLE pedido_item ADD CONSTRAINT fk_produto FOREIGN KEY ( produto_id ) REFERENCES produto ( registro ) ;

ALTER TABLE pedido_item ADD CONSTRAINT fk_pedido FOREIGN KEY ( pedido_id ) REFERENCES pedido ( id ) ;

ALTER TABLE pedido ADD CONSTRAINT fk_pessoa FOREIGN KEY ( pessoa_id ) REFERENCES pessoa ( id ) ;

ALTER TABLE pedido ADD CONSTRAINT fk_pedido_item FOREIGN KEY ( pedido_item_id ) REFERENCES pedido_item ( id ) ;




