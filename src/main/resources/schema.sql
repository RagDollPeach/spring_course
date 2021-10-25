DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS test_entities;
DROP TABLE IF EXISTS book_file_type;
DROP TABLE IF EXISTS file_download;
DROP TABLE IF EXISTS book2author;
DROP TABLE IF EXISTS book2genre;
DROP TABLE IF EXISTS book2user;
DROP TABLE IF EXISTS book2user_type;
DROP TABLE IF EXISTS book_review;
DROP TABLE IF EXISTS book_review_like;
DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS document;
DROP TABLE IF EXISTS faq;
DROP TABLE IF EXISTS balance_transaction;
DROP TABLE IF EXISTS user_contact;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS book_file;

CREATE TABLE author
(
    id          BIGSERIAL PRIMARY KEY,
    photo       VARCHAR(250) NOT NULL,
    slug        VARCHAR(250) NOT NULL,
    name        VARCHAR(250) NOT NULL,
    description TEXT
);
CREATE TABLE book
(
    id            BIGSERIAL PRIMARY KEY,
    pub_date      DATE         NOT NULL,
    is_bestseller SMALLINT     NOT NULL,
    slug          VARCHAR(250) NOT NULL,
    title         VARCHAR(250) NOT NULL,
    image         VARCHAR(250) NOT NULL,
    description   TEXT,
    price         VARCHAR(250) NOT NULL,
    discount      SMALLINT     NOT NULL DEFAULT 0
);
CREATE TABLE test_entities
(
    id   BIGSERIAL PRIMARY KEY,
    data VARCHAR(50) NOT NULL
);
CREATE TABLE book_file_type
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT         NOT NULL
);
CREATE TABLE file_download
(
    id      BIGSERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    count   INT NOT NULL DEFAULT 1
);
CREATE TABLE book2author
(
    id         BIGSERIAL PRIMARY KEY,
    book_id    INT NOT NULL,
    author_id  INT NOT NULL,
    sort_index INT NOT NULL DEFAULT 0
);
CREATE TABLE book2genre
(
    id       BIGSERIAL PRIMARY KEY,
    book_id  INT NOT NULL,
    genre_id INT NOT NULL
);
CREATE TABLE book2user
(
    id      BIGSERIAL PRIMARY KEY,
    time    TIMESTAMP NOT NULL,
    type_id INT       NOT NULL,
    book_id INT       NOT NULL,
    user_id INT       NOT NULL
);
CREATE TABLE book2user_type
(
    id   BIGSERIAL PRIMARY KEY,
    code VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL
);
CREATE TABLE book_review
(
    id      BIGSERIAL PRIMARY KEY,
    book_id INT       NOT NULL,
    user_id INT       NOT NULL,
    time    TIMESTAMP NOT NULL,
    text    TEXT      NOT NULL
);
CREATE TABLE book_review_like
(
    id        BIGSERIAL PRIMARY KEY,
    review_id INT       NOT NULL,
    user_id   INT       NOT NULL,
    time      TIMESTAMP NOT NULL,
    value     SMALLINT  NOT NULL
);
CREATE TABLE message
(
    id      BIGSERIAL PRIMARY KEY,
    time    TIMESTAMP    NOT NULL,
    user_id INT,
    email   VARCHAR(255),
    name    VARCHAR(255),
    subject VARCHAR(255) NOT NULL,
    text    TEXT         NOT NULL
);
CREATE TABLE genre
(
    id        BIGSERIAL PRIMARY KEY,
    parent_id INT,
    slug      VARCHAR(255) NOT NULL,
    name      VARCHAR(255) NOT NULL
);
CREATE TABLE document
(
    id         BIGSERIAL PRIMARY KEY,
    sort_index INT          NOT NULL DEFAULT 0,
    slug       VARCHAR(255) NOT NULL,
    title      VARCHAR(255) NOT NULL,
    text       TEXT         NOT NULL
);
CREATE TABLE faq
(
    id         BIGSERIAL PRIMARY KEY,
    sort_index INT          NOT NULL DEFAULT 0,
    question   VARCHAR(255) NOT NULL,
    answer     TEXT         NOT NULL
);
CREATE TABLE balance_transaction
(
    id          BIGSERIAL PRIMARY KEY,
    user_id     INT       NOT NULL,
    time        TIMESTAMP NOT NULL,
    value       INT       NOT NULL DEFAULT 0,
    book_id     INT       NOT NULL,
    description TEXT      NOT NULL
);
CREATE TABLE user_contact
(
    id          BIGSERIAL PRIMARY KEY,
    user_id     INT          NOT NULL,
    approved    SMALLINT     NOT NULL,
    code        VARCHAR(255) NOT NULL,
    code_trails INT,
    code_time   TIMESTAMP,
    contact     VARCHAR(255) NOT NULL
);
CREATE TABLE users
(
    id      BIGSERIAL PRIMARY KEY,
    hash    VARCHAR(255) NOT NULL,
    regTime TIMESTAMP    NOT NULL,
    balance INT          NOT NULL,
    name    VARCHAR(255) NOT NULL
);
CREATE TABLE book_file
(
    id      BIGSERIAL PRIMARY KEY,
    hash    VARCHAR(255) NOT NULL,
    path    VARCHAR(255) NOT NULL,
    type_id INT
);
