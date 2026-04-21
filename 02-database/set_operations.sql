\c the_fullstack_db

drop table if exists team_alpha, team_beta;

create table team_alpha(
	alpha_emp_id integer,
	alpha_name varchar(40)
);

insert into team_alpha values
(101, 'Alice'),
(102, 'Bob'),
(103, 'Charlie');

create table team_beta(
	beta_emp_id integer,
	beta_name varchar(40)
);

insert into team_beta (beta_emp_id, beta_name) values
(103, 'Charlie'),
(104, 'David'),
(105, 'Eve');