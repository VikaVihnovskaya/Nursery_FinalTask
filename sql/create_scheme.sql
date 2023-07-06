create schema animals;
create table cats
(
    id         bigint auto_increment,
    name       varchar(255) not null,
    date_birth timestamp    not null,
    commands   VARCHAR(255) null,
    constraint cats_pk
        primary key (id)
);

create table dogs
(
    id         bigint auto_increment,
    name       varchar(255) not null,
    date_birth timestamp    not null,
    commands   varchar(255) null,
    constraint dogs_pk
        primary key (id)
);

create table hamsters
(
    id         bigint auto_increment,
    name       varchar(255) not null,
    date_birth timestamp    not null,
    commands   varchar(255) null,
    constraint hamsters_pk
        primary key (id)
);

create table horses
(
    id         bigint auto_increment,
    name       varchar(255) not null,
    date_birth timestamp    not null,
    commands   varchar(255) null,
    constraint horses_pk
        primary key (id)
);

create table camels
(
    id         bigint auto_increment,
    name       varchar(255) not null,
    date_birth timestamp    not null,
    commands   varchar(255) null,
    constraint camels_pk
        primary key (id)
);
create table donkeys
(
    id         bigint auto_increment,
    name       varchar(255) not null,
    date_birth timestamp    not null,
    commands   varchar(255) null,
    constraint donkeys_pk
        primary key (id)
);