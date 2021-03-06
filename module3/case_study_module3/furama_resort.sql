drop database if exists furama_resort;
create database furama_resort;

use furama_resort;

create table vi_tri(
	ma_vi_tri int,
    ten_vi_tri varchar(45),
    primary key(ma_vi_tri),
    `status` bit default 0
);

create table trinh_do(
	ma_trinh_do int,
    ten_trinh_do varchar(45),
    primary key(ma_trinh_do),
    `status` bit default 0
);

create table bo_phan(
	ma_bo_phan int,
    ten_bo_phan varchar(45),
    primary key(ma_bo_phan),
    `status` bit default 0
);

create table gioi_tinh(
	ma_gioi_tinh bit(1),
    ten_gioi_tinh varchar(45),
    primary key(ma_gioi_tinh)
);

create table nhan_vien(
	ma_nhan_vien int auto_increment,
    ho_va_ten varchar(45),
    ma_gioi_tinh bit(1),
    ngay_sinh date,
    so_cmnd varchar(45),
    luong double,
	so_dien_thoai varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    ma_vi_tri int,
    ma_trinh_do int,
    ma_bo_phan int,
    `status` bit default 0,
    foreign key(ma_vi_tri) references vi_tri(ma_vi_tri),
    foreign key(ma_trinh_do) references trinh_do(ma_trinh_do),
    foreign key(ma_bo_phan) references bo_phan(ma_bo_phan),
    foreign key(ma_gioi_tinh) references gioi_tinh(ma_gioi_tinh),
    primary key(ma_nhan_vien)
);

create table loai_khach(
	ma_loai_khach int,
    ten_loai_khach varchar(45),
    primary key(ma_loai_khach),
    `status` bit default 0
);

create table khach_hang(
	ma_khach_hang int auto_increment,
    ma_loai_khach int,
    foreign key(ma_loai_khach) references loai_khach(ma_loai_khach),
    ho_ten varchar(45),
    ngay_sinh date,
    ma_gioi_tinh bit(1),
    foreign key(ma_gioi_tinh) references gioi_tinh(ma_gioi_tinh),
    so_cmnd varchar(45),
    so_dien_thoai varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    `status` bit default 0,
    primary key(ma_khach_hang)
);

create table loai_dich_vu(
	ma_loai_dich_vu int,
    ten_loai_dich_vu varchar(45),
    `status` bit default 0,
    primary key(ma_loai_dich_vu)
);


create table kieu_thue(
	ma_kieu_thue int,
    ten_kieu_thue varchar(45),
    `status` bit default 0,
    primary key(ma_kieu_thue)
);

create table dich_vu(
	ma_dich_vu int auto_increment,
    ten_dich_vu varchar(45),
    dien_tich int,
    chi_phi_thue double,
    so_nguoi_toi_da int,
    ma_kieu_thue int,
    ma_loai_dich_vu int,
    foreign key(ma_kieu_thue) references kieu_thue(ma_kieu_thue),
    foreign key(ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu),
    tieu_chuan_phong varchar(45),
    mo_ta_tien_nghi_khac varchar(45),
    dien_tich_ho_boi double,
    so_tang int,
    `status` bit default 0,
    primary key(ma_dich_vu)
);

create table hop_dong(
	ma_hop_dong int auto_increment,
    ngay_lam_hop_dong datetime,
    ngay_ket_thuc datetime,
    tien_dat_coc double,
    ma_nhan_vien int,
    ma_khach_hang int,
    ma_dich_vu int,
    `status` bit default 0,
    foreign key(ma_nhan_vien) references nhan_vien(ma_nhan_vien),
    foreign key(ma_khach_hang) references khach_hang(ma_khach_hang),
    foreign key(ma_dich_vu) references dich_vu(ma_dich_vu),
    primary key(ma_hop_dong)
);


create table dich_vu_di_kem(
	ma_dich_vu_di_kem int auto_increment,
    ten_dich_vu_di_kem varchar(45),
    gia double,
    don_vi varchar(10),
    trang_thai varchar(45),
    `status` bit default 0,
    primary key(ma_dich_vu_di_kem)
);

create table hop_dong_chi_tiet(
	ma_hop_dong_chi_tiet int auto_increment,
    ma_hop_dong int,
    ma_dich_vu_di_kem int,
    foreign key(ma_hop_dong) references hop_dong(ma_hop_dong),
    foreign key(ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem),
    so_luong int,
    `status` bit default 0,
    primary key(ma_hop_dong_chi_tiet)
);

insert into vi_tri(ma_vi_tri, ten_vi_tri) values (1, 'L??? t??n'), (2, 'Ph???c v???'),(3, 'Chuy??n vi??n'),(4, 'Gi??m s??t'),(5, 'Qu???n l??'),(6, 'Gi??m ?????c');
insert into trinh_do(ma_trinh_do, ten_trinh_do) values (1, 'Trung C???p'), (2, 'Cao ?????ng'), (3, '?????i H???c'), (4, 'Sau ?????i H???c');
insert into bo_phan(ma_bo_phan, ten_bo_phan) values (1, 'Sale-Marketing'), (2, 'H??nh ch??nh'), (3, 'Ph???c v???'), (4, 'Qu???n l??');
insert into loai_khach(ma_loai_khach, ten_loai_khach) value (1, 'Diamond'), (2, 'Platinum'), (3, 'Gold'), (4, 'Silver'), (5, 'Member');
insert into kieu_thue(ma_kieu_thue, ten_kieu_thue) value (1, 'Year'), (2, 'Month'), (3, 'Day'), (4, 'Hour');
insert into loai_dich_vu(ma_loai_dich_vu, ten_loai_dich_vu) value (1, 'Villa'), (2, 'House'), (3, 'Room');
insert into gioi_tinh(ma_gioi_tinh, ten_gioi_tinh) value (1, 'Nam'), (0, 'N???');
insert into nhan_vien(ho_va_ten, ma_gioi_tinh, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
value ('Nguy???n V??n An', 1,'1970-11-07', '456231786', 1000000, '0901234121', 'annguyen@gmail.com', '295 Nguy???n T???t Th??nh, ???? N???ng', 2, 3, 1),
('L?? V??n B??nh', 1,'1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Y??n B??i, ???? N???ng', 2, 2, 2),
('H??? Th??? Y???n', 0,'1995-12-12', '456231786', 1000000, '0901234121', 'thiyen@gmail.com', 'K234/11 ??i???n Bi??n Ph???, Gia Lai', 1, 3, 2),
('V?? C??ng To???n', 1,'1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Ho??ng Di???u, Qu???ng Tr???', 6, 4, 1),
('Nguy???n B???nh Ph??t', 1,'1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '294 Nguy???n T???t Th??nh, ???? N???ng', 2, 1, 1),
('Kh??c Nguy???n An Nghi', 0,'2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '4 Nguy???n Ch?? Thanh, Hu???', 1, 2, 3),
('Nguy???n H???u H??', 1,'1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '111 H??ng V????ng, H?? N???i', 4, 3, 2),
('Nguy???n H?? ????ng', 0,'1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '43 Y??n B??i, ???? N???ng', 5, 4, 4),
('T??ng Hoang', 0,'1982-09-03', '256781231', '6000000', '0245144444', 'hoangtong@gmail.com', '213 H??m Nghi, ???? N???ng', 3, 4, 4),
('Nguy???n C??ng ?????o',	1,'1994-01-08', '755434346', '8000000', '0988767111',	'nguyencongdao12@gmail.com', '6 Ho?? Kh??nh, ?????ng Nai', 2, 3, 2);


insert into khach_hang(ho_ten, ngay_sinh, ma_gioi_tinh,so_cmnd, so_dien_thoai, email, dia_chi, ma_loai_khach)
value ('Nguy???n Th??? H??o', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguy???n Ho??ng, ???? N???ng', 5),
('Ph???m Xu??n Di???u', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Th??i Phi??n, Qu???ng Tr???', 3),
('Tr????ng ????nh Ngh???', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 ??ng ??ch Khi??m, Vinh', 1),
('D????ng V??n Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 L?? L???i, ???? N???ng', 1),
('Ho??ng Tr???n Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 L?? Th??i T???, Gia Lai', 4),
('T??n N??? M???c Ch??u', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Y??n Th???, ???? N???ng', 4),
('Nguy???n M??? Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 L?? L???i, H??? Ch?? Minh', 1),
('Nguy???n Th??? H??o', '1999-04-08', 0, '856453123', '965656433', 'haohao99@gmail.com', '55 Nguy???n V??n Linh, Kon Tum', 3),
('Tr???n ?????i Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 L?? Th?????ng Ki???t, Qu???ng Ng??i', 1),
('Nguy???n T??m ?????c', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ng?? Quy???n, ???? N???ng', 2);

insert into dich_vu(ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang, ma_kieu_thue, ma_loai_dich_vu)
values('Villa Beach Front',	25000, 10000000, 10, 'vip',	'C?? h??? b??i', 500, 4, 3,	1),
('House Princess 01', 14000, 5000000, 7, 'vip',	'C?? th??m b???p n?????ng', null, 3, 2, 2),
('Room Twin 01', 5000, 1000000,	2, 'normal', 'C?? tivi',	null, null,	4, 3),
('Villa No Beach Front', 22000,	9000000, 8,	'normal', 'C?? h??? b??i', 300, 3, 3, 1),
('House Princess 02', 10000, 4000000, 5, 'normal',	'C?? th??m b???p n?????ng', null, 2, 3, 2),
('Room Twin 02', 3000, 900000, 2, 'normal',	'C?? tivi',	null, null,	4, 3);

insert into dich_vu_di_kem(ten_dich_vu_di_kem, gia, don_vi, trang_thai) 
values ('Karaoke', 10000, 'gi???', 'ti???n nghi, hi???n t???i'),
('Thu?? xe m??y',	10000, 'chi???c',	'h???ng 1 xe'),
('Thu?? xe ?????p',	20000, 'chi???c',	't???t'),
('Buffet bu???i s??ng', 15000,	'su???t',	'?????y ????? ????? ??n, tr??ng mi???ng'),
('Buffet bu???i tr??a', 90000,	'su???t',	'?????y ????? ????? ??n tr??ng mi???ng'),
('Buffet bu???i t???i',	16000, 'su???t',	'?????y ????? ????? ??n tr??ng mi???ng');

set foreign_key_checks = 0;
insert into hop_dong(ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu) 
values ('2020-12-08', '2020-12-08',	0, 3, 1, 3),
('2020-07-14', '2020-07-21', 200000, 7,	3, 1),
('2021-03-15', '2021-03-17', 50000,	3, 4, 2),
('2021-01-14', '2021-01-18', 100000, 7,	5, 5),
('2021-07-14', '2021-07-15', 0,	7, 2, 6),
('2021-06-01', '2021-06-03', 0,	7, 7, 6),
('2021-09-02', '2021-09-05', 100000, 7,	4, 4),
('2021-06-17', '2021-06-18', 150000, 3,	4, 1),
('2020-11-19', '2020-11-19', 0,	3,	4, 3),
('2021-04-12', '2021-04-14', 0,	10,	3, 5),
('2021-04-25', '2021-04-25', 0,	2,	2, 1),
('2021-05-25', '2021-05-27', 0,	7,	10,	1);
set foreign_key_checks = 1;


set foreign_key_checks = 0;
insert into hop_dong_chi_tiet(so_luong, ma_hop_dong, ma_dich_vu_di_kem) 
values (5, 2, 4),
(8,	2, 5),
(15, 2,	6),
(1,	3, 1),
(11, 3,	2),
(1,	1, 3),
(2,	1, 2),
(2,	12,	2);
set foreign_key_checks = 1;


-- Store procedure
use furama_resort;
delimiter //
create procedure insert_employee(in `name` varchar(120), in ma_gioi_tinh bit, in dob date, in id varchar(120),
in salary long, in sdt varchar(45), in email varchar(120), in address varchar(120), in ma_vi_tri int, in ma_trinh_do int, in ma_bo_phan int)
begin
	insert into nhan_vien(ho_va_ten, ma_gioi_tinh, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan) 
    values (`name`, ma_gioi_tinh, dob, id, salary, sdt, email, address, ma_vi_tri, ma_trinh_do, ma_bo_phan);
end;
delimiter //

use furama_resort;
delimiter //
create procedure update_employee(in code_employee int, in `name` varchar(120), in ma_gioi_tinh bit, in dob date, in id varchar(120),
in salary long, in sdt varchar(45), in email varchar(120), in address varchar(120), in ma_vi_tri int, in ma_trinh_do int, in ma_bo_phan int)
begin
	update nhan_vien set ho_va_ten= `name`, 
    ma_gioi_tinh= ma_gioi_tinh, 
    ngay_sinh= dob, 
    so_cmnd= id, 
    luong= salary, 
    so_dien_thoai= sdt, 
    email= email, 
    dia_chi= address, 
    ma_vi_tri= ma_vi_tri, 
    ma_trinh_do= ma_trinh_do, 
    ma_bo_phan= ma_bo_phan
    where ma_nhan_vien = code_employee
end;
delimiter //






-- task 2
-- Hi???n th??? th??ng tin c???a t???t c??? nh??n vi??n 
-- c?? trong h??? th???ng c?? t??n b???t ?????u l?? m???t trong c??c k?? t??? ???H???, ???T??? ho???c ???K??? v?? c?? t???i ??a 15 k?? t???.
select * from nhan_vien where (ho_va_ten like 'h%' or ho_va_ten like 'k%' or ho_va_ten like 't%') and char_length(ho_va_ten) < 15;
use furama_resort;

-- task 3
-- Hi???n th??? th??ng tin c???a t???t c??? kh??ch h??ng c?? ????? tu???i t??? 18 ?????n 50 tu???i v?? c?? ?????a ch??? ??? ??????? N???ng??? ho???c ???Qu???ng Tr??????.
select * from khach_hang where timestampdiff(year, ngay_sinh, now()) between 18 and 50 and dia_chi like '%???? n???ng%' or dia_chi like '%qu???ng tr???%';

-- task 4
-- ?????m xem t????ng ???ng v???i m???i kh??ch h??ng ???? t???ng ?????t ph??ng bao nhi??u l???n. 
-- K???t qu??? hi???n th??? ???????c s???p x???p t??ng d???n theo s??? l???n ?????t ph??ng c???a kh??ch h??ng. 
-- Ch??? ?????m nh???ng kh??ch h??ng n??o c?? T??n lo???i kh??ch h??ng l?? ???Diamond???.
use furama_resort;
select khach_hang.ma_khach_hang, khach_hang.ho_ten, count(hop_dong.ma_khach_hang) as so_lan_dat_phong from khach_hang 
inner join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang where khach_hang.ma_loai_khach like 1 group by ma_khach_hang order by so_lan_dat_phong;

-- task 5
-- Hi???n th??? ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien
-- cho t???t c??? c??c kh??ch h??ng ???? t???ng ?????t ph??ng. (nh???ng kh??ch h??ng n??o ch??a t???ng ?????t ph??ng c??ng ph???i hi???n th??? ra). 
use furama_resort; 
select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, dich_vu.ten_dich_vu, hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc,
dich_vu.chi_phi_thue +(ifnull(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia, 0)) as tong_tien
from khach_hang
left join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong, khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, dich_vu.ten_dich_vu, hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc;

-- task 6
-- Hi???n th??? ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
-- c???a t???t c??? c??c lo???i d???ch v??? ch??a t???ng ???????c kh??ch h??ng th???c hi???n ?????t t??? qu?? 1 c???a n??m 2021 (Qu?? 1 l?? th??ng 1, 2, 3).
use furama_resort;
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu dv
inner join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
inner join loai_dich_vu on dv.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu 
where dv.ma_dich_vu not in (select hd.ma_dich_vu from hop_dong hd where (quarter(hd.ngay_lam_hop_dong) = 1) and 
year(hd.ngay_lam_hop_dong) = 2021)
group by ma_dich_vu
order by ma_dich_vu;


-- task 7
-- Hi???n th??? th??ng tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu c???a 
-- t???t c??? c??c lo???i d???ch v??? ???? t???ng ???????c kh??ch h??ng ?????t ph??ng trong n??m 2020 nh??ng ch??a t???ng ???????c kh??ch h??ng ?????t ph??ng trong n??m 2021.
use furama_resort;
select hop_dong.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, 
loai_dich_vu.ten_loai_dich_vu
from hop_dong
inner join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
inner join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu 
where hop_dong.ma_dich_vu not in 
(select ma_dich_vu from hop_dong where year(ngay_lam_hop_dong) = 2021) and year(ngay_lam_hop_dong) = 2020
group by ma_dich_vu;

-- task 8
-- Hi???n th??? th??ng tin ho_ten kh??ch h??ng c?? trong h??? th???ng, v???i y??u c???u ho_ten kh??ng tr??ng nhau.
-- way 1
use furama_resort;
select distinct ho_ten from khach_hang;
-- way 2
use furama_resort;
select ho_ten from khach_hang group by ho_ten;
-- way 3
use furama_resort;
select ho_ten from khach_hang
union
select ho_ten from khach_hang;

-- task 9
-- Th???c hi???n th???ng k?? doanh thu theo th??ng, 
-- ngh??a l?? t????ng ???ng v???i m???i th??ng trong n??m 2021 th?? s??? c?? bao nhi??u kh??ch h??ng th???c hi???n ?????t ph??ng.
use furama_resort;
select month(h.ngay_lam_hop_dong) as thang,  count(year(h.ngay_lam_hop_dong) and month(h.ngay_lam_hop_dong)) as tong_doanh_thu from hop_dong h 
where year(h.ngay_lam_hop_dong) = 2021 group by thang order by thang;

-- task 10
-- Hi???n th??? th??ng tin t????ng ???ng v???i t???ng h???p ?????ng th?? ???? s??? d???ng bao nhi??u d???ch v??? ??i k??m. 
-- K???t qu??? hi???n th??? bao g???m ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
use furama_resort;
select h.ma_hop_dong, h.ngay_lam_hop_dong, h.ngay_ket_thuc, h.tien_dat_coc, ifnull(sum(hdct.so_luong), 0) as so_luong_dich_vu_di_kem from hop_dong h
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = h.ma_hop_dong
group by h.ma_hop_dong;

-- task 11
-- Hi???n th??? th??ng tin c??c d???ch v??? ??i k??m ???? ???????c 
-- s??? d???ng b???i nh???ng kh??ch h??ng c?? ten_loai_khach l?? ???Diamond??? v?? c?? dia_chi ??? ???Vinh??? ho???c ???Qu???ng Ng??i???.
use furama_resort;
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem from dich_vu_di_kem dvdk
inner join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
inner join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
inner join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
inner join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
where lk.ten_loai_khach = 'Diamond' and kh.dia_chi like '%Qu???ng Ng??i%' or kh.dia_chi like '%Vinh%'
order by dvdk.ma_dich_vu_di_kem;

-- task 12. Hi???n th??? th??ng tin c???a t???t c??? c??c d???ch v??? ???? t???ng ???????c kh??ch h??ng ?????t v??o 3 th??ng cu???i n??m 2020 
-- nh??ng ch??a t???ng ???????c kh??ch h??ng ?????t v??o 6 th??ng ?????u n??m 2021.
use furama_resort;
select hd.ma_hop_dong, nv.ho_va_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu,
ifnull(sum(hdct.so_luong), 0) as so_luong_dich_vu_di_kem, hd.tien_dat_coc
from hop_dong hd
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
inner join nhan_vien nv on nv.ma_nhan_vien = hd.ma_nhan_vien
inner join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
inner join dich_vu dv on dv.ma_dich_vu  = hd.ma_dich_vu
where (hd.ngay_lam_hop_dong between '2020-10-01' and '2020-12-31') and hd.ma_khach_hang not in (select hd.ma_khach_hang from hop_dong hd 
where (hd.ngay_lam_hop_dong between '2021-01-01' and '2021-06-30'))
group by hd.ma_hop_dong
order by hd.ma_hop_dong;

-- task 13 Hi???n th??? th??ng tin c??c D???ch v??? ??i k??m ???????c s??? d???ng nhi???u nh???t b???i c??c Kh??ch h??ng ???? ?????t ph??ng.
--  (L??u ?? l?? c?? th??? c?? nhi???u d???ch v??? c?? s??? l???n s??? d???ng nhi???u nh?? nhau).
use furama_resort;
select hdct.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_lan_su_dung
from hop_dong_chi_tiet hdct
inner join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by hdct.ma_dich_vu_di_kem
having so_lan_su_dung = (select max(hdct.so_luong) from hop_dong_chi_tiet hdct); 

-- task 14 
-- Hi???n th??? th??ng tin t???t c??? c??c D???ch v??? ??i k??m ch??? m???i ???????c s??? d???ng m???t l???n duy nh???t. 
-- Th??ng tin hi???n th??? bao g???m ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung 
use furama_resort;
select hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(hdct.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong_chi_tiet hdct
inner join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong
inner join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
inner join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
inner join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by dvdk.ten_dich_vu_di_kem
having count(hdct.ma_dich_vu_di_kem) = 1
order by hd.ma_hop_dong;


-- task 15
-- Hi???n thi th??ng tin c???a t???t c??? nh??n vi??n bao g???m ma_nhan_vien, 
-- ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi m???i ch??? l???p ???????c t???i ??a 3 h???p ?????ng t??? n??m 2020 ?????n 2021.
select nv.ma_nhan_vien, nv.ho_va_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
from nhan_vien nv
inner join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
inner join trinh_do td on td.ma_trinh_do = nv.ma_trinh_do
inner join bo_phan bp on bp.ma_bo_phan = nv.ma_bo_phan
group by nv.ma_nhan_vien
having count(nv.ma_nhan_vien) <= 3;

-- task 16
-- X??a nh???ng Nh??n vi??n ch??a t???ng l???p ???????c h???p ?????ng n??o t??? n??m 2019 ?????n n??m 2021.
use furama_resort;
set sql_safe_updates = 0; 
update nhan_vien
set nhan_vien.`status` = 1
where nhan_vien.ma_nhan_vien not in (select distinct hd.ma_nhan_vien from hop_dong hd);
set sql_safe_updates = 1;

-- task 17
-- C???p nh???t th??ng tin nh???ng kh??ch h??ng c?? ten_loai_khach t??? Platinum l??n Diamond, 
-- ch??? c???p nh???t nh???ng kh??ch h??ng ???? t???ng ?????t ph??ng v???i T???ng Ti???n thanh to??n trong n??m 2021 l?? l???n h??n 10.000.000 VN??.
set sql_safe_updates = 0; 
update khach_hang
set khach_hang.ma_loai_khach = 1
where khach_hang.ma_khach_hang 
in (select distinct hd.ma_khach_hang from hop_dong hd 
inner join dich_vu on dich_vu.ma_dich_vu = hd.ma_dich_vu
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hd.ma_hop_dong
inner join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
where dich_vu.chi_phi_thue +(ifnull(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia, 0)) > 10000000 and year(hd.ngay_lam_hop_dong) = 2021) ;
set sql_safe_updates = 1;


-- task 18
-- X??a nh???ng kh??ch h??ng c?? h???p ?????ng tr?????c n??m 2021 (ch?? ?? r??ng bu???c gi???a c??c b???ng).
set sql_safe_updates = 0; 
update khach_hang
set khach_hang.`status` = 1
where khach_hang.ma_khach_hang in (select distinct hd.ma_khach_hang from hop_dong hd where year(hd.ngay_lam_hop_dong) = 2020);
set sql_safe_updates = 1;


-- task 19
-- C???p nh???t gi?? cho c??c d???ch v??? ??i k??m ???????c s??? d???ng tr??n 10 l???n trong n??m 2020 l??n g???p ????i.
set sql_safe_updates = 0; 
update dich_vu_di_kem
set dich_vu_di_kem.gia = gia * 2
where dich_vu_di_kem.ma_dich_vu_di_kem in (select hdct.ma_dich_vu_di_kem from hop_dong_chi_tiet hdct 
inner join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
where hdct.so_luong > 10 and year(hd.ngay_lam_hop_dong) = 2020);
set sql_safe_updates = 1;


-- task 20
-- Hi???n th??? th??ng tin c???a t???t c??? c??c nh??n vi??n v?? kh??ch h??ng c?? trong h??? th???ng,
-- th??ng tin hi???n th??? bao g???m id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
use furama_resort;
create view danh_sach as
select nv.ma_nhan_vien, nv.ho_va_ten, nv.email, nv.so_dien_thoai, nv.ngay_sinh, nv.dia_chi
from nhan_vien nv
union 
select kh.ma_khach_hang, kh.ho_ten, kh.email, kh.so_dien_thoai, kh.ngay_sinh, kh.dia_chi
from khach_hang kh;




