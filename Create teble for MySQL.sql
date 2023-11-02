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
INSERT INTO pets (Name, Type, BirthData, Commands)
VALUES 
    ('Fibo', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
    ('Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
    ('Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
    ('Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
    ('Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
    ('Peanut', 'Hamster', '2021-08-01', 'Roll, Spin'),
    ('Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
    ('Oliver', 'Cat', '2020-06-30', 'Moew, Scratch, Jump');

INSERT INTO pack_animals (Name, Type, BirthData, Commands)
VALUES 
    ('Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
    ('Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
    ('Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
    ('Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
    ('Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
    ('Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick'),
    ('Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
    ('Sahara', 'Camel', '2015-08-14', 'Walk, Run');
