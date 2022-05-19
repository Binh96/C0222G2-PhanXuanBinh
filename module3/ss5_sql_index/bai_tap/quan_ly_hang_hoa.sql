drop database if exists quan_ly_hang_hoa;
create database quan_ly_hang_hoa;

use quan_ly_hang_hoa;

create table products(
	id int auto_increment primary key,
    product_code int,
    product_name varchar(45),
    product_amount varchar(45),
    product_description varchar(255),
    product_status bit default 0
);