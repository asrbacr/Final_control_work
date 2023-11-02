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
