use student;
drop table studentinfo;
 create table StudentInfo (id integer not null, age integer, className integer, email varchar(255) unique, 
fatherName varchar(255), firstName varchar(255), lastName varchar(255), primary key (id));


drop table users;
drop table authorities;

create table users (
 username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

 insert into users(username, password, enabled)values('admin','{noop}1234',true);
 insert into authorities(username,authority)values('admin','ROLE_ADMIN');
 
  insert into users(username, password, enabled)values('user','{noop}1234',true);
 insert into authorities(username,authority)values('user','ROLE_USER');

