drop database if exists quan_ly_hang_hoa;
create database quan_ly_hang_hoa;

use quan_ly_hang_hoa;

create table products(
    product_code int auto_increment primary key,
    product_name varchar(45),
    product_price int,
    product_amount int,
    product_description varchar(255),
    product_status bit default 0
);

insert into products(product_name, product_price, product_amount, product_description) 
values ('may giat', 1000, 9, 'tot'), ('bep dien', 2000, 8, 'xau'), ('ti vi', 3000, 3, 'tot'), ('tu lanh', 4000, 5, 'tot'),
		('dieu hoa', 5000, 10, 'xau'), ('dien thoai', 6000, 6, 'tot'), ('lo vi song', 7000, 3, 'xau'), ('tu lanh', 8000, 5, 'tot');


drop index unique_index2 on products;
drop index unique_index on products;
create unique index unique_index on products (product_code);
create index unique_index2 on products (product_name, product_price);
explain select * from products;


create view product_view as 
select product_code, product_name, product_price, product_status
from products;

create or replace view product_view as
select product_code, product_name, product_price, product_status
from products
where product_name = 'ti vi';

drop view product_view;


-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
use quan_ly_hang_hoa;
delimiter //

drop procedure if exists get_all_products;
create procedure get_all_products()
begin
	select * from products;
end //

delimiter //

call get_all_products();

-- Tạo store procedure thêm một sản phẩm mới
use quan_ly_hang_hoa;
delimiter //

drop procedure if exists create_new_products;
create procedure create_new_products(inout `name` varchar(255), inout price int(55), inout amount int(55), inout `description` varchar(45))
begin
	insert into products(product_name, product_price, product_amount, product_description)
    values (`name`, price, amount, `description`);
end //

delimiter //

set @`name` = 'xe oto';
set @price = 2000;
set @amount = 32;
set @`description` = 'tot';
call create_new_products(@`name`, @price, @amount, @`description`);

-- Tạo store procedure sửa thông tin sản phẩm theo id
use quan_ly_hang_hoa;
delimiter //
drop procedure if exists edit_products;
create procedure edit_products(id int(55), inout `name` varchar(255), inout price int(55), inout amount int(55), inout `description` varchar(45))
begin
	update products
    set product_name = `name`, product_price = price, product_amount = amount, product_description = `description`
    where product_code = id;
end //
delimiter //

set @`name` = 'may bay';
set @price = 222000;
set @amount = 32;
set @`description` = 'tot';
set @id = 11;
call edit_products(@id, @`name`, @price, @amount, @`description`);

-- Tạo store procedure xoá sản phẩm theo id
use quan_ly_hang_hoa;
delimiter //
drop procedure if exists delete_products;
create procedure delete_products(id int(55))
begin
	delete from products where product_code = id;
end //
delimiter //

set @id = 14;
call delete_products(@id);









