drop database if exists quan_ly_sinh_vien;
create database quan_ly_sinh_vien;

use quan_ly_sinh_vien;

CREATE TABLE Class(
    ClassID   INT AUTO_INCREMENT PRIMARY KEY,
    ClassName VARCHAR(60),
    StartDate DATETIME,
    Status    BIT
);

CREATE TABLE Student(
    StudentId   INT  AUTO_INCREMENT PRIMARY KEY,
    StudentName VARCHAR(30),
    Address     VARCHAR(50),
    Phone       VARCHAR(20),
    Status      BIT,
    ClassId     INT,
    FOREIGN KEY (ClassId) REFERENCES Class (ClassID)
);

CREATE TABLE Subjects(
    SubId   INT AUTO_INCREMENT PRIMARY KEY,
    SubName VARCHAR(30),
    Credit  TINYINT DEFAULT 1 CHECK ( Credit >= 1 ),
    Status  BIT DEFAULT 1
);

CREATE TABLE Mark(
    MarkId    INT AUTO_INCREMENT PRIMARY KEY,
    SubId     INT,
    StudentId INT,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);