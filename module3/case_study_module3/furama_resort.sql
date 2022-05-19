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

create table nhan_vien(
	ma_nhan_vien int auto_increment,
    ho_va_ten varchar(45),
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
    gioi_tinh bit(1),
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

insert into vi_tri(ma_vi_tri, ten_vi_tri) values (1, 'Quản lý'), (2, 'Nhân viên');
insert into trinh_do(ma_trinh_do, ten_trinh_do) values (1, 'Trung Cấp'), (2, 'Cao Đẳng'), (3, 'Đại Học'), (4, 'Sau Đại Học');
insert into bo_phan(ma_bo_phan, ten_bo_phan) values (1, 'Trung Cấp'), (2, 'Cao Đẳng'), (3, 'Đại Học'), (4, 'Sau Đại Học');
insert into loai_khach(ma_loai_khach, ten_loai_khach) value (1, 'Diamond'), (2, 'Platinum'), (3, 'Gold'), (4, 'Silver'), (5, 'Member');
insert into kieu_thue(ma_kieu_thue, ten_kieu_thue) value (1, 'Year'), (2, 'Month'), (3, 'Day'), (4, 'Hour');
insert into loai_dich_vu(ma_loai_dich_vu, ten_loai_dich_vu) value (1, 'Villa'), (2, 'House'), (3, 'Room');

insert into nhan_vien(ho_va_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
value ('Nguyễn Văn An', '1970-11-07', '456231786', 1000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1),
('Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2),
('Hồ Thị Yến', '1995-12-12', '456231786', 1000000, '0901234121', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),
('Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 1),
('Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 1, 1),
('Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 2, 3),
('Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '111 Hùng Vương, Hà Nội', 2, 3, 2),
('Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 4, 4),
('Tòng Hoang', '1982-09-03', '256781231', '6000000', '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
('Nguyễn Công Đạo',	'1994-01-08', '755434346', '8000000', '0988767111',	'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);


insert into khach_hang(ho_ten, ngay_sinh, gioi_tinh,so_cmnd, so_dien_thoai, email, dia_chi, ma_loai_khach)
value ('Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', 5),
('Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', 3),
('Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', 1),
('Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', 1),
('Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', 4),
('Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', 4),
('Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', 1),
('Nguyễn Thị Hào', '1999-04-08', 0, '856453123', '965656433', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', 3),
('Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', 1),
('Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng', 2);

insert into dich_vu(ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang, ma_kieu_thue, ma_loai_dich_vu)
values('Villa Beach Front',	25000, 10000000, 10, 'vip',	'Có hồ bơi', 500, 4, 3,	1),
('House Princess 01', 14000, 5000000, 7, 'vip',	'Có thêm bếp nướng', null, 3, 2, 2),
('Room Twin 01', 5000, 1000000,	2, 'normal', 'Có tivi',	null, null,	4, 3),
('Villa No Beach Front', 22000,	9000000, 8,	'normal', 'Có hồ bơi', 300, 3, 3, 1),
('House Princess 02', 10000, 4000000, 5, 'normal',	'Có thêm bếp nướng', null, 2, 3, 2),
('Room Twin 02', 3000, 900000, 2, 'normal',	'Có tivi',	null, null,	4, 3);

insert into dich_vu_di_kem(ten_dich_vu_di_kem, gia, don_vi, trang_thai) 
values ('Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
('Thuê xe máy',	10000, 'chiếc',	'hỏng 1 xe'),
('Thuê xe đạp',	20000, 'chiếc',	'tốt'),
('Buffet buổi sáng', 15000,	'suất',	'đầy đủ đồ ăn, tráng miệng'),
('Buffet buổi trưa', 90000,	'suất',	'đầy đủ đồ ăn tráng miệng'),
('Buffet buổi tối',	16000, 'suất',	'đầy đủ đồ ăn tráng miệng');

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

-- task 2
select * from nhan_vien where (ho_va_ten like 'h%' or ho_va_ten like 'k%' or ho_va_ten like 't%') and char_length(ho_va_ten) < 15;
use furama_resort;

-- task 3
select * from khach_hang where timestampdiff(year, ngay_sinh, now()) between 18 and 50 and dia_chi like '%đà nẵng%' or dia_chi like '%quảng trị%';

-- task 4
use furama_resort;
select khach_hang.ma_khach_hang, khach_hang.ho_ten, count(hop_dong.ma_khach_hang) as so_lan_dat_phong from khach_hang 
inner join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang where khach_hang.ma_loai_khach like 1 group by ma_khach_hang order by so_lan_dat_phong;

-- task 5
use furama_resort; 
select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, dich_vu.ten_dich_vu, hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc,
dich_vu.chi_phi_thue +(ifnull(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia, 0)) as tong_tien
from khach_hang
left join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong;

-- task 6
use furama_resort;
select hop_dong.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from hop_dong
inner join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
inner join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu where year(ngay_lam_hop_dong) = 2021 and month(ngay_lam_hop_dong) > 3 group by ma_dich_vu;


-- task 7
use furama_resort;
select hop_dong.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, 
loai_dich_vu.ten_loai_dich_vu
from hop_dong
inner join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
inner join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu 
where hop_dong.ma_dich_vu not in 
(select ma_dich_vu from hop_dong where year(ngay_lam_hop_dong) = 2021)
group by ma_dich_vu;

-- task 8
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
use furama_resort;
select month(h.ngay_lam_hop_dong) as thang,  count(year(h.ngay_lam_hop_dong) and month(h.ngay_lam_hop_dong)) as tong_doanh_thu from hop_dong h 
where year(h.ngay_lam_hop_dong) = 2021 group by thang order by thang;

-- task 10
use furama_resort;
select h.ma_hop_dong, h.ngay_lam_hop_dong, h.ngay_ket_thuc, h.tien_dat_coc, ifnull(sum(hdct.so_luong), 0) as so_luong_dich_vu_di_kem from hop_dong h
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = h.ma_hop_dong
group by h.ma_hop_dong;

-- task 11
use furama_resort;
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem from dich_vu_di_kem dvdk
inner join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
inner join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
inner join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
inner join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
where lk.ten_loai_khach = 'Diamond' and kh.dia_chi like '%Quảng Ngãi%' or kh.dia_chi like '%Vinh%'
order by dvdk.ma_dich_vu_di_kem;

-- task 12
use furama_resort;
select hd.ma_hop_dong, nv.ho_va_ten, kh.ho_ten, kh.so_dien_thoai, ldv.ten_loai_dich_vu,
ifnull(sum(hdct.so_luong), 0) as so_luong_dich_vu_di_kem, hd.tien_dat_coc
from hop_dong hd
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
inner join nhan_vien nv on nv.ma_nhan_vien = hd.ma_nhan_vien
inner join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
inner join dich_vu dv on dv.ma_dich_vu  = hd.ma_dich_vu
inner join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
where (year(hd.ngay_lam_hop_dong) = 2021 and month(hd.ngay_lam_hop_dong) between 7 and 12)
or (year(hd.ngay_lam_hop_dong) = 2020 and month(hd.ngay_lam_hop_dong) between 9 and 12)
group by hd.ma_hop_dong
order by hd.ma_hop_dong;

-- task 13
use furama_resort;
select hdct.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_lan_su_dung
from hop_dong_chi_tiet hdct
inner join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by hdct.ma_dich_vu_di_kem
having sum(hdct.so_luong) = (select max(hdct.so_luong)from hop_dong_chi_tiet hdct); 

-- task 14
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
select nv.ma_nhan_vien, nv.ho_va_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
from nhan_vien nv
inner join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
inner join trinh_do td on td.ma_trinh_do = nv.ma_trinh_do
inner join bo_phan bp on bp.ma_bo_phan = nv.ma_bo_phan
group by nv.ma_nhan_vien
having count(nv.ma_nhan_vien) <= 3;


-- task 16
set sql_safe_updates = 0; 
update nhan_vien
set nhan_vien.`status` = 1
where nhan_vien.ma_nhan_vien not in (select distinct hd.ma_nhan_vien from hop_dong hd);
set sql_safe_updates = 1;

-- task 17
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
set sql_safe_updates = 0; 
update khach_hang
set khach_hang.`status` = 1
where khach_hang.ma_khach_hang in (select distinct hd.ma_khach_hang from hop_dong hd where year(hd.ngay_lam_hop_dong) = 2020);
set sql_safe_updates = 1;


-- task 19
set sql_safe_updates = 0; 
update dich_vu_di_kem
set dich_vu_di_kem.gia = gia * 2
where dich_vu_di_kem.ma_dich_vu_di_kem in (select hdct.ma_dich_vu_di_kem from hop_dong_chi_tiet hdct 
inner join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
where hdct.so_luong > 10 and year(hd.ngay_lam_hop_dong) = 2020);
set sql_safe_updates = 1;


-- task 20
use furama_resort;
create view danh_sach as
select nv.ma_nhan_vien, nv.ho_va_ten, nv.email, nv.so_dien_thoai, nv.ngay_sinh, nv.dia_chi
from nhan_vien nv;

use furama_resort;
create view danh_sach_khach_hang as
select kh.ma_khach_hang, kh.ho_ten, kh.email, kh.so_dien_thoai, kh.ngay_sinh, kh.dia_chi
from khach_hang kh;























