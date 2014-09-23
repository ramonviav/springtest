CREATE DATABASE springtest;

GRANT ALL ON springtest.* TO springtestuser@'%' IDENTIFIED BY 'pspringtestuser';
GRANT ALL ON springtest.* TO springtestuser@localhost IDENTIFIED BY 'pspringtestuser';

USE springtest;

CREATE TABLE products (
  id INTEGER PRIMARY KEY,
  description varchar(255),
  price decimal(15,2)
);
CREATE INDEX products_description ON products(description);