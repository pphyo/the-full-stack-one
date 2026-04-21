\c the_fullstack_db

DROP TABLE IF EXISTS employees, departments;

CREATE TABLE departments(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL
);

CREATE TABLE employees(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(100) UNIQUE,
	salary NUMERIC(9, 2) NOT NULL,
	department_id INTEGER,
	FOREIGN KEY(department_id) REFERENCES departments(id)
);

INSERT INTO departments (name) VALUES ('HR'), ('Sales'), ('Accounting'), ('IT'), ('Finance');

INSERT INTO employees (name, salary) VALUES ('Josh', 30000);
INSERT INTO employees (name, salary) VALUES ('Anna', 28000);
INSERT INTO employees (name, salary, department_id) VALUES ('Isbella Merced', 55000, 3);
INSERT INTO employees (name, salary, department_id) VALUES ('Christiano Ronaldo', 70000, 1);
INSERT INTO employees (name, salary, department_id) VALUES ('Leonel Messi', 70000, 1);
INSERT INTO employees (name, salary, department_id) VALUES ('Monica', 50000, 4);
INSERT INTO employees (name, salary, department_id) VALUES ('Peter', 60000, 2);