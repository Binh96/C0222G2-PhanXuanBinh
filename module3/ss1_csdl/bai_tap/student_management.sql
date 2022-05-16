drop database if exists student_management;
create database student_management;
use student_management;

create table student(
	d int primary key,
    name_student varchar(45),
    age int,
    country varchar(45)
);

create table teacher(
	id int primary key,
    name_teacher varchar(45),
    age int,
    country varchar(45)
);

create table class(
	id int,
    class_name varchar(45)
);