\c the_fullstack_db;

drop table if exists orders cascade;
drop table if exists customers;
drop type if exists GENDER;

create type GENDER as ENUM('Male', 'Female');

create table customers ( -- parent
	id serial primary key,
	name text not null,
	email text unique,
	gender gender not null
);

create table orders ( -- child (owner)
	id serial primary key,
	order_date timestamp not null default(now()),
	unit_price numeric(9, 2) not null,
	quantity integer not null,
	customer_id integer default 1,
	foreign key(customer_id) references customers(id)
		on update set default
		on delete set default
);

insert into customers (name, gender) values ('Ko Soe Than', 'Male');
insert into customers (name, email, gender) values ('Tin Win Kyine', 'tinwinkyine@gmail.com', 'Male');
insert into customers (name, email, gender) values ('Ma Tin Hla', 'tinhla@microsoft.com', 'Female');
insert into customers (name, email, gender) values ('Shune Wati', 'watishune@yahoo.com', 'Female');

insert into orders (unit_price, quantity, customer_id) values (400, 4, 1);
insert into orders (unit_price, quantity, customer_id) values (1200, 2, 2);
insert into orders (unit_price, quantity, customer_id) values (3000, 1, 1);
insert into orders (unit_price, quantity, customer_id) values (1500, 2, 3);
insert into orders (unit_price, quantity, customer_id) values (4300, 6, 2);
insert into orders (unit_price, quantity, customer_id) values (200, 5, 2);
insert into orders (unit_price, quantity) values (500, 2);