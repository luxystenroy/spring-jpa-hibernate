create table person
(id integer not null,
name varchar(255),
location varchar(255),
birth_date timestamp,
primary key(id)
);

insert into person(id,name,location,birth_date) values (100,'Luis','Tome',sysdate());
insert into person(id,name,location,birth_date) values (101,'Peter','Concepcion',sysdate());
insert into person(id,name,location,birth_date) values (102,'Juan','Concepcion',sysdate());
