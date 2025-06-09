create database membertest;
use membertest;

create table member(
	id varchar(10) primary key,
	pwd varchar(10),
	name varchar(10)
);

select * from member;