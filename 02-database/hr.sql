\c the_fullstack_db;

drop table if exists employees, offices;

CREATE TABLE offices (
  office_id serial,
  address text NOT NULL,
  city character varying(50) NOT NULL,
  state character(2) NOT NULL,
  PRIMARY KEY (office_id)
);
INSERT INTO offices VALUES (1,'03 Reinke Trail','Cincinnati','OH');
INSERT INTO offices VALUES (2,'5507 Becker Terrace','New York City','NY');
INSERT INTO offices VALUES (3,'54 Northland Court','Richmond','VA');
INSERT INTO offices VALUES (4,'08 South Crossing','Cincinnati','OH');
INSERT INTO offices VALUES (5,'553 Maple Drive','Minneapolis','MN');
INSERT INTO offices VALUES (6,'23 North Plaza','Aurora','CO');
INSERT INTO offices VALUES (7,'9658 Wayridge Court','Boise','ID');
INSERT INTO offices VALUES (8,'9 Grayhawk Trail','New York City','NY');
INSERT INTO offices VALUES (9,'16862 Westend Hill','Knoxville','TN');
INSERT INTO offices VALUES (10,'4 Bluestem Parkway','Savannah','GA');

CREATE TABLE employees (
  employee_id serial,
  first_name character varying(50) NOT NULL,
  last_name character varying(50) NOT NULL,
  job_title character varying(50) NOT NULL,
  salary integer NOT NULL,
  office_id integer NOT NULL,
  PRIMARY KEY (employee_id),
  CONSTRAINT fk_employees_offices FOREIGN KEY (office_id) REFERENCES offices (office_id) ON UPDATE CASCADE
);
INSERT INTO employees VALUES (37270,'Yovonnda','Magrannell','Executive Secretary',63996,10);
INSERT INTO employees VALUES (33391,'D''arcy','Nortunen','Account Executive',62871,1);
INSERT INTO employees VALUES (37851,'Sayer','Matterson','Statistician III',98926,1);
INSERT INTO employees VALUES (40448,'Mindy','Crissil','Staff Scientist',94860,1);
INSERT INTO employees VALUES (56274,'Keriann','Alloisi','VP Marketing',110150,1);
INSERT INTO employees VALUES (63196,'Alaster','Scutchin','Assistant Professor',32179,2);
INSERT INTO employees VALUES (67009,'North','de Clerc','VP Product Management',114257,2);
INSERT INTO employees VALUES (67370,'Elladine','Rising','Social Worker',96767,2);
INSERT INTO employees VALUES (68249,'Nisse','Voysey','Financial Advisor',52832,2);
INSERT INTO employees VALUES (72540,'Guthrey','Iacopetti','Office Assistant I',117690,3);
INSERT INTO employees VALUES (72913,'Kass','Hefferan','Computer Systems Analyst IV',96401,3);
INSERT INTO employees VALUES (75900,'Virge','Goodrum','Information Systems Manager',54578,3);
INSERT INTO employees VALUES (76196,'Mirilla','Janowski','Cost Accountant',119241,3);
INSERT INTO employees VALUES (80529,'Lynde','Aronson','Junior Executive',77182,4);
INSERT INTO employees VALUES (80679,'Mildrid','Sokale','Geologist II',67987,4);
INSERT INTO employees VALUES (84791,'Hazel','Tarbert','General Manager',93760,4);
INSERT INTO employees VALUES (95213,'Cole','Kesterton','Pharmacist',86119,4);
INSERT INTO employees VALUES (96513,'Theresa','Binney','Food Chemist',47354,5);
INSERT INTO employees VALUES (98374,'Estrellita','Daleman','Staff Accountant IV',70187,5);
INSERT INTO employees VALUES (115357,'Ivy','Fearey','Structural Engineer',92710,5);