use quan_ly_ban_hang;

insert into customer(c_id, c_name, c_age) 
values (1, 'Minh Quan', 10), (2, 'Ngoc Oanh', 20), (3, 'Hong Ha', 50);

use quan_ly_ban_hang;
insert into order_bill(o_id, c_id, o_date) 
values (1, 1, '2006-03-21'),(2, 2, '2006-03-23'), (3, 1, '2006-03-16');

use quan_ly_ban_hang;
insert into product(p_id, p_name, p_price) 
values(1, 'May giat', 3),(2, 'Tu Lanh', 5),(3, 'Dieu Hoa', 7),(4, 'Quat', 1),(5, 'Bep dien', 2);

use quan_ly_ban_hang;
insert into order_detail(o_id, p_id, od_qty) 
values(1, 1, 3), (1, 3, 7), (1, 4, 2), (2, 1, 1), (3, 1, 8), (2, 5, 4), (2, 3, 3);

use quan_ly_ban_hang;
select o_id, o_date, o_totalprice from order_bill;

use quan_ly_ban_hang;
select c.c_name, p.p_name from customer c
inner join product p 
left join order_bill ob on ob.c_id = c.c_id
left join order_detail od on od.p_id = p.p_id group by od.o_id;

use quan_ly_ban_hang;
select c.c_name, p.p_name from order_bill ob
inner join customer c on ob.c_id = c.c_id
inner join order_detail od on od.o_id = ob.o_id
inner join product p on od.p_id = p.p_id;

use quan_ly_ban_hang;
select c.c_name from customer c where not exists (select c_name from order_bill where c.c_id = order_bill.c_id);

use quan_ly_ban_hang;
select ob.o_id, ob.o_date, (p.p_price * od.od_qty) as gia_tien from order_bill ob
inner join order_detail od on od.o_id = ob.o_id
inner join product p on p.p_id = od.p_id;