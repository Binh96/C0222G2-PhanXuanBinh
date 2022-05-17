drop database if exists quan_ly_vat_tu;
create database quan_ly_vat_tu;
use quan_ly_vat_tu;

create table nha_cc(
	ma_ncc int auto_increment primary key,
	name_ncc varchar(255),
	address_ncc varchar(255)
);

create table sđt(
	phone varchar(255),
	ma_ncc int,
	foreign key (ma_ncc) references nha_cc(ma_ncc)
);

create table don_dh(
	so_dh int auto_increment primary key,
	ngay_dh datetime,
	ma_ncc int,
	foreign key (ma_ncc) references nha_cc(ma_ncc)
);

create table phieu_nhap(
	so_pn int auto_increment primary key,
	ngay_nhap datetime
);

create table phieu_xuat(
	so_px int auto_increment primary key,
	ngay_xuat datetime
);

create table vat_tu(
	ma_vat_tu int auto_increment primary key,
	name_vat_tu varchar(255)
);

create table chi_tiet_px(
	so_px int,
	ma_vat_tu int,
	sl_xuat int,
	dg_xuat double,
	primary key (so_px,ma_vat_tu),
	foreign key (so_px) references phieu_xuat(so_px),
	foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table chi_tiet_pn(
	so_pn int,
	ma_vat_tu int,
	sl_nhap int,
	dg_xuat double,
	primary key(so_pn,ma_vat_tu),
	foreign key (so_pn) references phieu_nhap(so_pn),
	foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);
create table chi_tiet_dondh(
	so_dh int,
	ma_vat_tu int,
	primary key (so_dh,ma_vat_tu),
	foreign key (so_dh) references don_dh(so_dh),
	foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);