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

-- Создал таблицу связи животного и команды
CREATE TABLE commands ( 
    animals_id INT,
    command_id INT,
    FOREIGN KEY (animals_id) REFERENCES animals (id),
    FOREIGN KEY (command_id) REFERENCES commands_animals (id)
);

-- Добавил связи
INSERT INTO commands 
VALUES
    (1, 1), (1, 2), (1, 3), (2, 1), (2, 4), (3, 5),
    (3, 6), (4, 1), (4, 7), (4, 8), (5, 1), (5, 4),
    (5, 9), (6, 5), (6, 10), (7, 1), (7, 2), (7, 5),
    (8, 11), (8, 9), (8, 12), (9, 13), (9, 14), (9, 15),
    (10, 16), (10, 17), (11, 16), (11, 17), (11, 18), (12, 13),
    (12, 14), (13, 16), (13, 1), (14, 16), (14, 18), (14, 19),
    (15, 13), (15, 12), (15, 15), (16, 16), (16, 20);

-- Вывод Лист "Pets"
SELECT DISTINCT name, name_type, birth_date, name_group, name_command FROM animals
JOIN type_animals ON type_animals.id = animals.type_id
JOIN group_animals ON group_animals.id = animals.group_id
JOIN commands ON commands.animals_id = animals.id
JOIN commands_animals ON commands_animals.id = commands.command_id
WHERE group_id = 1;

-- Вывод Лист "Pack Animals"
SELECT DISTINCT name, name_type, birth_date, name_group, name_command FROM animals
JOIN type_animals ON type_animals.id = animals.type_id
JOIN group_animals ON group_animals.id = animals.group_id
JOIN commands ON commands.animals_id = animals.id
JOIN commands_animals ON commands_animals.id = commands.command_id
WHERE group_id = 2;

