CREATE DATABASE human_friends;
USE human_friends;

-- Создание таблиц
CREATE TABLE human_friends.pets (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(45) NULL,
    Type VARCHAR(45) NULL,
    BirthData DATE NULL,
    Commands VARCHAR(100) NULL
);

CREATE TABLE human_friends.pack_animals (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(45) NULL,
    Type VARCHAR(45) NULL,
    BirthData DATE NULL,
    Commands VARCHAR(100) NULL
);

-- Заполнение таблиц данными
