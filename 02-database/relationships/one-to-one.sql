\c the_fullstack_db;

DROP TABLE IF EXISTS passports, people;

DROP TYPE IF EXISTS GENDER, PASSPORT_TYPE;

CREATE TYPE GENDER AS ENUM('Male', 'Female');
CREATE TYPE PASSPORT_TYPE AS ENUM('PV', 'PJ', 'PE');

CREATE TABLE people(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	dob DATE NOT NULL,
	gender GENDER NOT NULL,
	phone VARCHAR(15)
);

CREATE TABLE passports(
	id SERIAL PRIMARY KEY,
	passport_no VARCHAR(15) NOT NULL UNIQUE,
	issued_date DATE NOT NULL,
	expired_date DATE GENERATED ALWAYS AS (issued_date + INTERVAL '5 years'),
	passport_type PASSPORT_TYPE NOT NULL,
	people_id INTEGER NOT NULL UNIQUE REFERENCES people(id)
);

INSERT INTO people (name, dob, gender, phone) VALUES
('Jack', '1998-10-20', 'Male', '102939944'),
('Clara', '2001-03-12', 'Female', '304932223'),
('Denise', '2003-12-28', 'Female', '583924433'),
('Blake', '2008-01-30', 'Male', '482949293'),
('Tadashi', '1990-06-23', 'Male', '994348020');

INSERT INTO passports (passport_no, issued_date, passport_type, people_id) VALUES
('PPN-39493', '2025-03-30', 'PV', 1),
('PPN-39494', '2024-02-14', 'PJ', 2),
('PPN-39495', '2022-10-24', 'PE', 3),
('PPN-39496', '2025-05-15', 'PV', 4),
('PPN-39497', '2026-01-16', 'PV', 5);
