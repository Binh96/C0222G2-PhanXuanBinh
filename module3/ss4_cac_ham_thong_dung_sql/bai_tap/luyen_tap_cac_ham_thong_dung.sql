use quan_ly_sinh_vien;

select * from subjects where credit in (select max(credit) from subjects);

select * from mark where mark in (select max(mark) from mark); 

select s.*, avg(m.mark) as diem_trung_binh from student s
inner join mark m on m.StudentId = s.StudentId group by s.StudentId;
