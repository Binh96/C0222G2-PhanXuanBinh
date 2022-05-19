use quan_ly_sinh_vien;

select * from student where studentname like 'h%';
select * from class where month(startdate) = 12;
select * from subjects where credit > 3 and credit < 5;

use quan_ly_sinh_vien;
set sql_safe_updates =0;
update student set classid = 3 where studentname like 'hung';
set sql_safe_updates =1;

use quan_ly_sinh_vien;
select s.studentname, sub.subname, m.mark from student s
join mark m on s.StudentId = m.studentid
join subjects sub on sub.subid = m.subid
order by m.mark desc, s.studentname;

