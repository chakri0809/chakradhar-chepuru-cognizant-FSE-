use ormlearn;

create table employee (
    id int not null auto_increment,
    first_name varchar(50),
    last_name varchar(50),
    salary int,
    primary key (id)
);
