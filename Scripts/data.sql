use mybatis_study;

insert into addresses (addr_id,street,city,state,zip,country) values
(1,'4891 Pacific Hwy','San Diego','CA','92110','San Diego'),
(2,'2400 N Jefferson St','Perry','FL','32347','Tayler'),
(3,'710 N Cable Rd','Lima','OH','45825','Allen'),
(4,'5108 W Gore Blvd','Lawton','OK','32365','comanche');

insert into students (stud_id,name,email,phone,dob,bio,pic,addr_id) values
(1,'Timothy','timothy@gmail.com','123-123-1234','1988-04-25',null,null,3),
(2,'Douglas','douglas@gmail.com','789-456-1234','1990-08-15',null,null,4);

insert into tutors (tutor_id,name,email,phone,dob,bio,pic,addr_id) values
(1,'John','john@gmail.com','111-222-3333','1980-05-20',null,null,1),
(2,'Ken','ken@gmail.com','111-222-3333','1980-05-20',null,null,1),
(3,'Paul','paul@gmail.com','123-321-4444','1981-03-15',null,null,2),
(4,'Mike','mike@gmail.com','123-321-4444','1981-03-15',null,null,2);

insert into courses (course_id,name,description,start_date,end_date,tutor_id) values
(1,'Quickstart Core Java','Core Java Programming','2013-03-01','2013-04-15',1),
(2,'Quickstart JavaEE6','Enterprise App Development using JavaEE6','2013-04-01','2013-08-30',1),
(3,'MyBatis3 Premier','MyBatis 3 framework','2013-06-01','2013-07-15',2);

insert into course_enrollment (course_id,stud_id) values
(1,1),
(1,2),
(2,2);