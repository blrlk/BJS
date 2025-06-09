create database BookMarketDB;
use BookMarketDB;

CREATE TABLE board (
       num int not null auto_increment,	--자동으로 증가 - 입력하는 게 아님
       id varchar(10) not null,
       name varchar(10) not null,
       subject varchar(100) not null,
       content text not null,
       regist_day varchar(30),
       hit int,
       ip varchar(20),
       PRIMARY KEY (num)
)default CHARSET=utf8;

select * from board;
desc board;
drop table board;