use classicmodels;

delimiter //
DROP PROCEDURE IF EXISTS find_all_customers//
create procedure find_all_customers()
begin
		select * from customers;
end //

delimiter //

call find_all_customers();

delimiter //
DROP PROCEDURE IF EXISTS find_all_customers//
create procedure find_all_customers()
begin
	select * from customers where customerNumber = 175;
end //
delimiter //

call find_all_customers();