DROP table person if exists;

create table person
(id integer not null,
name varchar(255),
location varchar(255),
birthdate timestamp,
primary key(id)
);

insert into person(id,name,location,birthdate) values (100,'Luis','Tome',sysdate());
insert into person(id,name,location,birthdate) values (101,'Peter','Concepcion',sysdate());
insert into person(id,name,location,birthdate) values (102,'Juan','Concepcion',sysdate());
