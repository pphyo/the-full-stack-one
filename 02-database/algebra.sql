\c the_fullstack_db;

drop table if exists employees, offices;

create table employees(
	emp_id integer not null,
	name varchar(40) not null,
	department varchar(40),
	salary decimal(9, 2) not null
);

create table offices(
	department varchar(40) not null,
	building varchar(40) not null
);

insert into employees values
(101, 'Alice', 'IT', 80000),
(102, 'Bob', 'HR', 60000),
(103, 'Charlie', 'IT', 75000),
(103, 'David', null, 50000);

insert into offices values
('IT', 'Tower A'),
('HR', 'Tower B'),
('Sales', 'Tower C');