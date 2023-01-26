INSERT INTO university.rooms(floor,number)
VALUES(1,101);
INSERT INTO university.rooms(floor,number)
VALUES(1,102);
INSERT INTO university.rooms(floor,number)
VALUES(1,103);
INSERT INTO university.rooms(floor,number)
VALUES(1,104);
INSERT INTO university.rooms(floor,number)
VALUES(1,105);
INSERT INTO university.rooms(floor,number)
VALUES(1,106);
INSERT INTO university.rooms(floor,number)
VALUES(1,107);
INSERT INTO university.rooms(floor,number)
VALUES(1,108);
INSERT INTO university.rooms(floor,number)
VALUES(1,109);
INSERT INTO university.rooms(floor,number)
VALUES(1,110);
INSERT INTO university.rooms(floor,number)
VALUES(2,101);
INSERT INTO university.rooms(floor,number)
VALUES(2,102);
INSERT INTO university.rooms(floor,number)
VALUES(2,103);
INSERT INTO university.rooms(floor,number)
VALUES(2,104);
INSERT INTO university.rooms(floor,number)
VALUES(2,105);
INSERT INTO university.rooms(floor,number)
VALUES(2,106);
INSERT INTO university.rooms(floor,number)
VALUES(2,107);
INSERT INTO university.rooms(floor,number)
VALUES(2,108);
INSERT INTO university.rooms(floor,number)
VALUES(2,109);
INSERT INTO university.rooms(floor,number)
VALUES(2,110);
INSERT INTO university.rooms(floor,number)
VALUES(3,101);
INSERT INTO university.rooms(floor,number)
VALUES(3,102);
INSERT INTO university.rooms(floor,number)
VALUES(3,103);
INSERT INTO university.rooms(floor,number)
VALUES(3,104);
INSERT INTO university.rooms(floor,number)
VALUES(3,105);
INSERT INTO university.rooms(floor,number)
VALUES(3,106);
INSERT INTO university.rooms(floor,number)
VALUES(3,107);
INSERT INTO university.rooms(floor,number)
VALUES(3,108);
INSERT INTO university.rooms(floor,number)
VALUES(3,109);
INSERT INTO university.rooms(floor,number)
VALUES(3,110);

INSERT INTO university.subjects(name)
VALUES('Engineering Thermodynamics');
INSERT INTO university.subjects(name)
VALUES('Structure of Materials');
INSERT INTO university.subjects(name)
VALUES('Principles of Extractive Metallurgy');
INSERT INTO university.subjects(name)
VALUES('Phase Transformations');
INSERT INTO university.subjects(name)
VALUES('Introduction to Metallurgy and Materials Engineering');
INSERT INTO university.subjects(name)
VALUES('Metallurgical Thermodynamics and Kinetics');
INSERT INTO university.subjects(name)
VALUES('Mechanical Behaviour of Materials');
INSERT INTO university.subjects(name)
VALUES('Instrumental Analysis');
INSERT INTO university.subjects(name)
VALUES('Higher Mathematics');

INSERT INTO university.groups(name)
VALUES('ME-0609');
INSERT INTO university.groups(name)
VALUES('MA-1010');
INSERT INTO university.groups(name)
values('MQ-1612');

INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(1,3,'Thailia Beck','Thailia@gmail.com','1992-01-02');
INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(1,3,'Jade Skeldon','Skeldon@gmail.com','1992-05-03');
INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(1,3,'Gardner Hargraves','Hargraves@gmail.com','1992-01-10');
INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(1,3,'Clara Manwaring','Manwaring@gmail.com','1992-05-01');
INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(1,3,'Robin Glover','Glover@gmail.com','1992-01-02');
INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(2,2,'Joe Estrada','Estrada@gmail.com','1991-01-05');
INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(2,2,'Caldwell Cooke','Cooke@gmail.com','1991-06-01');
INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(2,2,'Phil Lindsey','Lindsey@gmail.com','1991-04-01');
INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(2,2,'Timothea Simmons','Simmons@gmail.com','1991-06-10');
INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(2,2,'Elena Gregory','Gregory@gmail.com','1991-01-25');
INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(3,1,'Violent Badman','Badman@gmail.com','1990-05-07');
INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(3,1,'Gale Conner','Conner@gmail.com','1990-07-29');
INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(3,1,'Mona French','French@gmail.com','1990-12-01');
INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(3,1,'Jim Wade','Wade@gmail.com','1990-04-30');
INSERT INTO university.students(group_id,course,name,email,birthday)
VALUES(3,1,'Maria Jimenes','Thailia@gmail.com','1990-06-18');

INSERT INTO university.teachers(name, email, birthday, subject_id, position)
VALUES ('Craig Terry', 'c.terry@gmail.com','1975-08-19',1,'Research Instructor');
INSERT INTO university.teachers(name, email, birthday, subject_id, position)
VALUES ('Henry Bowen', 'h.bowen@gmail.com','1984-03-16', 2, 'Research Instructor');
INSERT INTO university.teachers(name, email, birthday, subject_id, position)
VALUES ('Harmony Richards','h.richards@gmail.com','1979-05-17',3, 'Research Instructor');
INSERT INTO university.teachers(name, email, birthday, subject_id, position)
VALUES ('Gregory Vaughn', 'g.vaughn@gmail.com', '1988-04-13',4, 'Research Professor');
INSERT INTO university.teachers(name, email, birthday, subject_id, position)
VALUES ('Zach Watkins', 'z.watkins@gmail.com','1989-10-30', 5,'Research Professor');
INSERT INTO university.teachers(name, email, birthday, subject_id, position)
VALUES ('Pearl Jimenez','p.jimenez@gmail.com','1983-11-05', 6,'Research Professor');
INSERT INTO university.teachers(name, email, birthday, subject_id, position)
VALUES ('Laurel Jarvis', 'l.jarvis@gamail.com', '1987-05-16', 7, 'Research Professor');
INSERT INTO university.teachers(name, email, birthday, subject_id, position)
VALUES ('Lionel Patton', 'l.patton@gmail.com', '1988-03-16', 8, 'Research Professor');
INSERT INTO university.teachers(name, email, birthday, subject_id, position)
VALUES ('Jcqueline Curry', 'j.curry@gmail.com', '1976-01-13', 9, 'Research Associate Professor');
INSERT INTO university.teachers(name, email, birthday, subject_id, position)
VALUES ('Minerva Holt', 'm.holt@gmail.com', '1990-07-13', 9, 'Research Associate Professor');

INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (1,1);
INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (2,1);
INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (3,1);
INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (4,1);
INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (5,1);
INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (6,2);
INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (7,2);
INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (8,2);
INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (9,2);
INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (10,2);
INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (11,3);
INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (12,3);
INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (13,3);
INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (14,3);
INSERT INTO university.groupsstudents(student_id, group_id)
VALUES (15,3);

insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(30,1,10,5,'9:30','10:30','2022-06-05');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(29,1,9,9,'10:45','11:45','2022-06-05');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(28,2,8,8,'9:30','10:30','2022-06-05');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(27,2,7,7,'10:45','11:45','2022-06-05');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(26,3,6,6,'9:30','10:30','2022-06-05');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(25,3,5,5,'10:45','11:45','2022-06-05');

insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(24,1,4,4,'9:30','10:30','2022-06-06');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(23,1,3,3,'10:45','11:45','2022-06-06');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(22,2,2,2,'9:30','10:30','2022-06-06');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(21,2,1,1,'10:45','11:45','2022-06-06');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(20,3,10,5,'9:30','10:30','2022-06-06');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(19,3,9,9,'10:45','11:45','2022-06-06');

insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(18,1,8,8,'9:30','10:30','2022-06-07');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(17,1,7,8,'10:45','11:45','2022-06-07');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(16,2,6,6,'9:30','10:30','2022-06-07');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(15,2,5,5,'10:45','11:45','2022-06-07');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(14,3,4,4,'9:30','10:30','2022-06-07');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(13,3,3,3,'10:45','11:45','2022-06-07');

insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(12,1,2,2,'9:30','10:30','2022-06-08');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(11,1,1,1,'10:45','11:45','2022-06-08');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(10,2,10,4,'9:30','10:30','2022-06-08');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(9,2,9,9,'10:45','11:45','2022-06-08');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(8,3,8,8,'9:30','10:30','2022-06-08');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(7,3,7,7,'10:45','11:45','2022-06-08');

insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(6,1,6,6,'9:30','10:30','2022-06-09');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(5,1,5,5,'10:45','11:45','2022-06-09');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(4,2,4,4,'9:30','10:30','2022-06-09');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(3,2,3,3,'10:45','11:45','2022-06-09');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(2,3,2,2,'9:30','10:30','2022-06-09');
insert into university.lessons(room_id,group_id,teacher_id,subject_id,start_time,end_time,date)
values(1,3,1,1,'10:45','11:45','2022-06-09');

insert into university.roles(name)
values ('ADMIN');
insert into university.roles(name)
values ('TEACHER');
insert into university.roles(name)
values ('STUDENT');


