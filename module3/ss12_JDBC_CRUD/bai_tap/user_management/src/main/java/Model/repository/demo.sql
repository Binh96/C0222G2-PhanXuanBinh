create database demo;
use demo;

create table `users`(
	id int(3) not null auto_increment primary key,
    `name` varchar(45) not null,
    email varchar(120) not null,
    country varchar(120)
);

insert into `users`(`name`, email, country) values ('Minh', 'minh@codegym.vn', 'Viet Nam'),
('Kante', 'kante@che.uk', 'Kenia');