create database student_management;
use student_management;
create table class(
	id int,
    name_student varchar(45),
	primary key(id)
);

create table teacher(
	id int,
    name_teacher varchar(45),
    age int,
    country varchar(45),
    primary key(id)
);

