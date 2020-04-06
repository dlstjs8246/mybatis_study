select user(), database();

select * from addresses;
select * from students;
select * from tutors;
select * from courses;
select * from course_enrollment;

select stud_id, name, email, dob, phone,
			substring(phone,1,3) as f,
			substring(phone,5,3) as m,
			substring(phone,9,4) as l
			from students where stud_id = 1;

desc students;
insert into students(stud_id,name,email,phone,dob) values (3,'홍길동','dlstjs8246@naver.com','010-1111-1111','1990-09-03');
select * from students;
alter table students modify column gender tinyint(1) unsigned;
select * from user_pics;