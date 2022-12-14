drop table if exists ro_passport;
drop table if exists ro_birth_certificate;
drop table if exists ro_marriage_certificate;
drop table if exists ro_person;

create table ro_person
(
    person_id  serial       not null,
    sex        smallint     not null,
    first_name varchar(100) not null,
    last_name  varchar(100) not null,
    patronymic varchar(100),
    date_birth date         not null,
    primary key (person_id)
);

create table ro_passport
(
    passport_id      serial      not null,
    person_id        integer     not null,
    series           varchar(10) not null,
    number           varchar(10) not null,
    date_issue       date        not null,
    issue_department varchar(200),
    primary key (passport_id),
    foreign key (person_id) references ro_person (person_id) on delete restrict
);

create table ro_birth_certificate
(
    birth_certificate_id serial      not null,
    number_certificate   varchar(20) not null,
    date_issue           date        not null,
    person_id            integer     not null,
    father_id            integer     not null,
    mother_id            integer     not null,
    primary key (birth_certificate_id),
    foreign key (person_id) references ro_person (person_id) on delete restrict,
    foreign key (father_id) references ro_person (person_id) on delete restrict,
    foreign key (mother_id) references ro_person (person_id) on delete restrict
);

create table ro_marriage_certificate
(
    marriage_certificate_id serial      not null,
    number_certificate      varchar(20) not null,
    date_issue              date        not null,
    husband_id              integer     not null,
    wife_id                 integer     not null,
    active                  boolean default false,
    end_date                date,
    primary key (marriage_certificate_id),
    foreign key (husband_id) references ro_person (person_id) on delete restrict,
    foreign key (wife_id) references ro_person (person_id) on delete restrict
);

insert into ro_person(sex, first_name, last_name, patronymic, date_birth)
values (1, '??????????', '??????????????????', '??????????????????', '1998-03-24'),
       (2, '????????', '????????????????', '????????????????', '1997-10-16'),
       (2, '??????????????', '????????????????', '????????????????', '2018-10-21');

insert into ro_passport (person_id, series, number, date_issue, issue_department)
values (1, '40000', '123456', '2018-04-10', 'Department passport');

insert into ro_birth_certificate(number_certificate, date_issue, person_id, father_id, mother_id)
values ('123 Birth', '2018-1-01', '3', '2', '1');
