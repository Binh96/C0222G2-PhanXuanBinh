drop database if exists quan_ly_mat_bang;
create database quan_ly_mat_bang;

use quan_ly_mat_bang;

create table mat_bang(
	ma_loai_mat_bang int primary key auto_increment,
    ten_loai_mat_bang varchar(120)
);

create table trang_thai_mat_bang(
	ma_trang_thai int primary key auto_increment,
    ten_loai_trang_thai varchar(120)
);

create table toa_nha(
	ma_mat_bang varchar(120) primary key,
    ha_tang int,
    dien_tich double,
    so_tang int,
    loai_mat_bang int,
    mo_ta_chi_tiet varchar(120),
    gia_tien int,
    ngay_bat_dau date,
    ngay_ket_thuc date,
    `status` bit default 0,
    foreign key (ha_tang) references trang_thai_mat_bang(ma_trang_thai),
    foreign key (loai_mat_bang) references mat_bang(ma_loai_mat_bang)
);

insert into mat_bang(ten_loai_mat_bang) values ('Văn phòng chia sẽ'),('Văn phòng trọn gói');
insert into trang_thai_mat_bang(ten_loai_trang_thai) values ('Trống'), ('Hạ tầng'), ('Đầy đủ');

insert into toa_nha(ma_mat_bang, ha_tang, dien_tich, so_tang, loai_mat_bang, mo_ta_chi_tiet, gia_tien, ngay_bat_dau, ngay_ket_thuc) 
values ('ABC-ED-OL', 1, 100, 3, 1, 'new',1000000, '2020-07-14', '2022-07-18'),
('ABD-AH-XA', 1, 200, 3, 2, 'new',2000000, '2020-08-14', '2022-08-18'),
('ABE-CF-DA', 2, 90, 4, 2, 'old',3000000, '2020-09-14', '2030-09-18'),
('ABF-AX-RE', 3, 60, 5, 2, 'new',4000000, '2020-10-14', '2026-10-18'),
('ABG-BC-FG', 3, 80, 6, 1, 'old',5000000, '2020-11-14', '2024-11-18'),
('ABH-ED-AX', 2, 70, 1, 2, 'old',6000000, '2020-12-14', '2021-12-18'),
('ABI-ED-KI', 1, 50, 2, 1, 'new',7000000, '2020-01-20', '2023-03-18');

use quan_ly_mat_bang;
select * from toa_nha 
join mat_bang on toa_nha.loai_mat_bang = mat_bang.ma_loai_mat_bang
join trang_thai_mat_bang on toa_nha.ha_tang = trang_thai_mat_bang.ma_trang_thai
where ma_mat_bang like 'ABE-CF-DA' 
and mat_bang.ma_loai_mat_bang like  2 and trang_thai_mat_bang.ma_trang_thai like 2;

delimiter //
create procedure delete_toa_nha(in ma varchar(120))
begin
update toa_nha set `status` = 1 where ma_mat_bang = ma;
end ;


delimiter //
create procedure insert_toa_nha(in ma varchar(120), in ha_tang int, dien_tich double, in so_tang int, in loai_mat_bang int, 
in mo_ta_chi_tiet varchar(120), in gia_tien int, in ngay_bat_dau date, in ngay_ket_thuc date)
begin
insert into toa_nha(ma_mat_bang, ha_tang, dien_tich, so_tang, loai_mat_bang, mo_ta_chi_tiet, gia_tien, ngay_bat_dau, ngay_ket_thuc)
values (ma, ha_tang, dien_tich, so_tang, loai_mat_bang, mo_ta_chi_tiet, gia_tien, ngay_bat_dau, ngay_ket_thuc);
end ;