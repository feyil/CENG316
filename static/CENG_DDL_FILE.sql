CREATE DATABASE CENGDB;

USE CENGDB;

CREATE TABLE USER(
	ID INT NOT NULL AUTO_INCREMENT,
    UEMAIL VARCHAR(30) NOT NULL unique,
    UPASSWORD CHAR(60) NOT NULL,
    UTYPE VARCHAR(30) NOT NULL,
    UNAMESURNAME VARCHAR(30) NOT NULL,
    UTITLE VARCHAR(30) NOT NULL,
	PRIMARY KEY (ID));
    
INSERT INTO USER(UEMAIL, UPASSWORD,UTYPE, UNAMESURNAME, UTITLE)
VALUES ('app@ceng.com', '$2a$05$77azOIF/ZCDBVhIHPLZhseNg/H6nsMjcAIZ1NgAoV/YkN0GDo4N.e', 'Admin', 'App CENG', 'App');

create table EMAIL_MEMBER(
	ID int not null auto_increment,
    NAMESURNAME varchar(30) not null,
    EMAIL varchar(30) not null unique,
    GRADE int not null,
    primary key(ID));
    
create table EMAIL_MEMBER_GROUP(
	ID int not null auto_increment,
    MEMBER_ID int not null,
    GROUP_ID int not null,
    primary key(ID));
    
create table EMAIL_GROUP(
	ID int not null auto_increment,
    NAME varchar(30) not null unique,
    primary key(ID));