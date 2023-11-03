CREATE DATABASE human_friends;
USE human_friends;

-- Выделил уникальные типы животных
CREATE TABLE type_animals (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    name_type VARCHAR(20)
);

INSERT INTO type_animals (name_type)
VALUES 
    ('Dog'),
    ('Cat'),
    ('Hamster'),
    ('Horse'),
    ('Camel'),
    ('Donkey');

-- Выделил уникальные группы животных
CREATE TABLE group_animals (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    name_group VARCHAR(20)
);

INSERT INTO group_animals (name_group)
VALUES 
    ('pats'),
    ('pack_animals');

-- Выделил уникальные команды животных
CREATE TABLE commands_animals (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    name_command VARCHAR(40)
);

INSERT INTO commands_animals (name_command)
VALUES 
    ('Sit'), ('Stay'), ('Fetch'),
    ('Pounce'), ('Roll'), ('Hide'),
    ('Paw'), ('Bark'), ('Scratch'),
    ('Spin'), ('Meow'), ('Jump'),
    ('Trot'), ('Canter'), ('Gallop'),
    ('Walk'), ('Carry Load'), ('Bray'),
    ('Kick'), ('Run');

SELECT * FROM commands_animals;
SELECT * FROM group_animals;
SELECT * FROM type_animals;   
-- Создаю общую таблицу с животными
CREATE TABLE animals (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(40) NOT NULL,
    type_id INT,
    birth_date DATE,
    group_id INT,
    
    FOREIGN KEY (type_id) REFERENCES type_animals (id),
    FOREIGN KEY (group_id) REFERENCES group_animals (id)
);

-- Заполнениен таблицы данными
INSERT INTO animals (name, type_id, birth_date, group_id)
VALUES 
    ('Fido', 1, '2020-01-01', 1),
    ('Whiskers', 2, '2019-05-15', 1),
    ('Hammy', 3, '2021-03-10', 1),
    ('Buddy', 1, '2018-12-10', 1),
    ('Smudge', 2, '2020-02-20', 1),
    ('Peanut', 3, '2021-08-01', 1),
    ('Bella', 1, '2019-11-11', 1),
    ('Oliver', 2, '2020-06-30', 1),
    ('Thunder', 4, '2015-07-21', 2), 
    ('Sandy', 5, '2016-11-03', 2), 
    ('Eeyore', 6, '2017-09-18', 2), 
    ('Storm', 4, '2014-05-05', 2), 
    ('Dune', 5, '2018-12-12', 2), 
    ('Burro', 6, '2019-01-23', 2), 
    ('Blaze', 4, '2016-02-29', 2), 
    ('Sahara', 5, '2015-08-14', 2);
