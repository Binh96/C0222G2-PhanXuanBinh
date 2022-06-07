drop database if exists demo;
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

delimiter $$
create procedure get_user_by_id(in user_id int)
begin

select users.name, users.email, users.country
from users
where users.id = users_id

end//
delimiter;

DELIMITER $$

CREATE PROCEDURE insert_user(

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50)

)

BEGIN

    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);

    END$$

DELIMITER ;