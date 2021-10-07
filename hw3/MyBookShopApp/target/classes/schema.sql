DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

CREATE TABLE authors(
    id int AUTO_INCREMENT primary key,
    first_name varchar(250) not null,
    last_name varchar(250) not null
);

CREATE TABLE  books(
id INT AUTO_INCREMENT PRIMARY KEY,
authorId INT NOT NULL,
title VARCHAR(250) NOT NULL,
priceOld  VARCHAR(250) DEFAULT NULL,
price VARCHAR(250) DEFAULT NULL
);