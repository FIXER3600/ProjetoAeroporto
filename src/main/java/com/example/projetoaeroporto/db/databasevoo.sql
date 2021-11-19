CREATE TABLE voo (
                     id int NOT NULL AUTO_INCREMENT,
                     origem varchar(100),
                     destino varchar(100),
                     decolagem date ,
                     preco double ,

                     PRIMARY KEY(id)
);

-- Insere um Voo

INSERT INTO voo (id, origem, destino, decolagem, preco)
VALUES (1, 'Bahia', 'São Paulo', '2020-05-11', 50.0);