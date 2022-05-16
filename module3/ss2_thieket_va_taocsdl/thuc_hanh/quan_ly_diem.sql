drop database if exists quan_ly_diem;
create database quan_ly_diem;

use quan_ly_diem;

create table hoc_sinh(
	ma_hs varchar(20) primary key,
    ten_hs varchar(50),
    ngay_sinh date,
    lop varchar(20),
    gt varchar(20)
); 

create table mon_hoc(
	ma_mh varchar(20) primary key,
    ten_mh varchar(50)
);

create table giao_vien(
	ma_gv varchar(20) primary key,
    ten_gv varchar(20),
    sdt varchar(10)
);

alter table mon_hoc add ma_gv varchar(20);
alter table mon_hoc add constraint fk_ma_gv foreign key(ma_gv) references giao_vien(ma_gv);

