BEGIN TRANSACTION;

DROP TABLE IF EXISTS bk_user;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS bk_user_book;



CREATE TABLE author(
author_id SERIAL PRIMARY KEY,
firstname VARCHAR (50),
lastname VARCHAR (50)
);

CREATE TABLE book(
book_id SERIAL PRIMARY KEY,
author_id INT NOT NULL,
title VARCHAR(100) NOT NULL,
length INT NOT NULL, 
isbn VARCHAR(20),
date_started DATE,
date_ended DATE,
CONSTRAINT fk_book_author_name FOREIGN KEY (author_id) REFERENCES author (author_id)
);

CREATE TABLE bk_user(
user_id SERIAL PRIMARY KEY,
username VARCHAR (50) NOT NULL UNIQUE,
password_hash VARCHAR(200) NOT NULL,
CONSTRAINT UQ_username UNIQUE (username)
);


CREATE TABLE bk_user_book(
user_id INT,
book_id INT,

CONSTRAINT pk_bk_user_book PRIMARY KEY (user_id),
CONSTRAINT fk_bk_user_book_user_id FOREIGN KEY (user_id) REFERENCES bk_user(user_id),
CONSTRAINT fk_bk_user_book_book_id FOREIGN KEY (book_id) REFERENCES book (book_id)
);

ROLLBACK;
COMMIT;