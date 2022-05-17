use quan_ly_sinh_vien;

select address, count(studentid) as so_luong_hoc_vien
from student
group by address;

select s.studentid, s.studentname, avg(mark)
from student s join mark m on s.studentid = m.studentid
group by s.studentid, s.studentname;

select s.studentid, s.studentname, avg(mark)
from student s join mark m on s.studentid = m.studentid
group by s.studentid, s.studentname
having avg(mark) > 15;

select s.studentid, s.studentname, avg(mark)
from student s join mark m on s.studentid = m.studentid
group by s.studentid, s.studentname
having avg(mark) >= all (select avg(mark) from mark group by mark.studentid);