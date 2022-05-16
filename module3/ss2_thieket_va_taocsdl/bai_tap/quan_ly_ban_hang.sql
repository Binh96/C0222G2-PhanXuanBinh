drop database if exists quan_ly_ban_hang;
create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table customer(
	c_id int auto_increment primary key,
    c_name varchar(45),
    c_age int
);

create table order_bill(
	o_id int auto_increment primary key,
    o_date date,
    o_totalprice long,
    c_id int,
    foreign key(c_id) references customer(c_id)
);

create table product(
	p_id int auto_increment primary key,
    p_name varchar(45),
    p_price long
);

create table order_detail(
	o_id int,
    p_id int,
    od_qty varchar(45),
    foreign key(p_id) references product(p_id),
    foreign key(o_id) references order_bill(o_id)
);