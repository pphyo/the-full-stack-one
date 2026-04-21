\c the_fullstack_db

DROP TABLE IF EXISTS categories;

CREATE TABLE categories(
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	category_id INTEGER REFERENCES categories(id)
);

insert into categories (name) values ('Mobiles');
insert into categories (name) values ('Drinks');
insert into categories (name) values ('Foods');
insert into categories (name, category_id) values ('Samsung', 1);
insert into categories (name, category_id) values ('iPhone', 1);
insert into categories (name, category_id) values ('Energy Drinks', 2);
insert into categories (name, category_id) values ('Beer', 2);
insert into categories (name, category_id) values ('Whisky', 2);
insert into categories (name, category_id) values ('Snacks', 3);
insert into categories (name, category_id) values ('Fast Foods', 3);