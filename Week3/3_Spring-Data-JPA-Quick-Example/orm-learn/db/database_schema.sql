CREATE SCHEMA ormlearn;

USE ormlearn;

CREATE TABLE country (
    code VARCHAR(2) PRIMARY KEY,
    name VARCHAR(50)
);


INSERT INTO country VALUES ('US', 'United States of America');
INSERT INTO country VALUES ('JP', 'Japan');
INSERT INTO country VALUES ('CN', 'China');