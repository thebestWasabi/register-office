drop table if exist person;

create table person (
    person_id serial not null,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    primary key (person_id)
);