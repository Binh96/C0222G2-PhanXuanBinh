drop database if exists spring_security;
create database spring_security;

use spring_security;
create table app_user(
	user_id int primary key AUTO_INCREMENT,
    user_name varchar(255),
    encrypted_password varchar(255),
    enabled bit(1)
);

create table app_role(
	role_id int primary key AUTO_INCREMENT,
    role_name varchar(255)
);

create table user_role(
	id int primary key,
    user_id int,
    role_id int,
    foreign key(user_id) references app_user(user_id),
    foreign key(role_id) references app_role(role_id)
);