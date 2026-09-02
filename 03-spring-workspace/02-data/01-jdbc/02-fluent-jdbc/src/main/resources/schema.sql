CREATE TABLE tags (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL
);

CREATE TABLE products (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE product_details (
	product BIGINT PRIMARY KEY,
	remark TEXT,
	sku VARCHAR(50),
	FOREIGN KEY (product) REFERENCES products(id)
);

CREATE TABLE reviews (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	product_id BIGINT NOT NULL,
	reviewer_name VARCHAR(100),
	rating INT,
	FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE product_tags (
	product_id BIGINT NOT NULL,
	tag_id BIGINT NOT NULL,
	PRIMARY KEY (product_id, tag_id),
	FOREIGN KEY (product_id) REFERENCES products(id),
	FOREIGN KEY (tag_id) REFERENCES tags(id)
);