--liquibase formatted sql

--changeset serge:1
CREATE TABLE IF NOT EXISTS remind
(
    id BIGSERIAL PRIMARY KEY ,
    title VARCHAR(255) NOT NULL ,
    description VARCHAR(4096),
    remind timestamp NOT NULL
);