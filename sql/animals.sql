create table animals
(
    id         bigint auto_increment,
    name       varchar(255) not null,
    date_birth date    not null,
    commands   varchar(255) null,
    species   VARCHAR(255) not null,
    primary key (id),
    external_id int null
);

INSERT INTO animals (name, date_birth, commands, species, external_id)
SELECT name, date_birth, commands,'cats' AS species, id
FROM cats;

INSERT INTO animals (name, date_birth, commands, species, external_id)
SELECT name, date_birth, commands,'dogs' AS species, id
FROM dogs;

INSERT INTO animals (name, date_birth, commands, species, external_id)
SELECT name, date_birth, commands,'hamsters' AS species, id
FROM hamsters;

INSERT INTO animals (name, date_birth, commands, species, external_id)
SELECT name, date_birth, commands,'horses' AS species, id
FROM horses;