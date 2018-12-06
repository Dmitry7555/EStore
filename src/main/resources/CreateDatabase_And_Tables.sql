CREATE DATABASE shop;
USE shop;

CREATE TABLE users(id_user int (10)  AUTO_INCREMENT,login VARCHAR(15) UNIQUE NOT NULL, name VARCHAR (15) NOT NULL, password VARCHAR(15) NOT NULL, PRIMARY KEY (id_user));
CREATE TABLE products(id_pr int (10) AUTO_INCREMENT, name VARCHAR(15) UNIQUE NOT NULL, description VARCHAR (15) NOT NULL,cost int (10) NOT NULL, PRIMARY KEY (id_pr));
CREATE TABLE basket(id_buy int (10) AUTO_INCREMENT,id_buer int(10) , idPr int (10) NOT NULL, PRIMARY KEY (id_buy), FOREIGN KEY (id_buer) REFERENCES users (id_user),FOREIGN KEY (idPr) REFERENCES products(id_pr));
INSERT INTO users (login, name, password) VALUES (1,1,1);

commit;
