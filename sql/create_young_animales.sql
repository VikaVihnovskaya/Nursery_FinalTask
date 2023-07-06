
create table young_animals
(
    id         bigint auto_increment,
    name       varchar(255) not null,
    age_month  int   not null,
    species   VARCHAR(255) null,
    constraint cats_pk
    primary key (id)
);

INSERT INTO young_animals (name, species, age_month)
SELECT name, 'Cat' AS `species`, TIMESTAMPDIFF(MONTH, date_birth, CURDATE()) AS 'age_months'
FROM cats
WHERE cats.date_birth <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) AND cats.date_birth >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR);

INSERT INTO young_animals (name, species, age_month)
SELECT name, 'Dog' AS `species`, TIMESTAMPDIFF(MONTH, date_birth, CURDATE()) AS 'age_months'
FROM dogs
WHERE dogs.date_birth <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) AND dogs.date_birth >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR);

INSERT INTO young_animals (name, species, age_month)
SELECT name, 'Hamsters' AS `species`, TIMESTAMPDIFF(MONTH, date_birth, CURDATE()) AS 'age_months'
FROM hamsters
WHERE hamsters.date_birth <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) AND hamsters.date_birth >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR);

INSERT INTO young_animals (name, species, age_month)
SELECT name, 'Horses' AS `species`, TIMESTAMPDIFF(MONTH, date_birth, CURDATE()) AS 'age_months'
FROM horses
WHERE horses.date_birth <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) AND horses.date_birth >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR);