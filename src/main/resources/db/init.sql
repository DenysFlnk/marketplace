DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS user_favorites;
DROP TABLE IF EXISTS product_rating;
DROP TABLE IF EXISTS product_img;
DROP TABLE IF EXISTS product_category;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS user_img;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;


CREATE TABLE users (
	id 			SERIAL PRIMARY KEY,
	username 	VARCHAR,
	email 		VARCHAR,
	us_password VARCHAR,
	CONSTRAINT user_email_idx UNIQUE (email)
);

CREATE TABLE roles (
	id 			SERIAL PRIMARY KEY,
	name		VARCHAR
);

CREATE TABLE user_role (
	user_id 	INTEGER NOT NULL,
	role_id 	INTEGER NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
	FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE,
	CONSTRAINT user_role_idx UNIQUE (user_id, role_id)
);

CREATE TABLE user_img (
    id 			SERIAL PRIMARY KEY,
	user_id 	INTEGER NOT NULL,
	img_url		VARCHAR,
	FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
	CONSTRAINT user_idx UNIQUE (user_id)
);

CREATE TABLE product (
	id 			SERIAL PRIMARY KEY,
	creator_id  INTEGER NOT NULL,
	name        VARCHAR NOT NULL,
	quantity 	INTEGER NOT NULL,
	price 		INTEGER NOT NULL,
	description TEXT,
	FOREIGN KEY (creator_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE INDEX product_name_idx ON product (name);

CREATE TABLE category (
	id 			SERIAL PRIMARY KEY,
	name		VARCHAR
);
CREATE INDEX category_name_idx ON category USING HASH (name);

CREATE TABLE product_category (
	product_id 	INTEGER NOT NULL,
	category_id	INTEGER NOT NULL,
	FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE,
	FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE
);

CREATE TABLE product_img (
	id 			SERIAL PRIMARY KEY,
	product_id 	INTEGER NOT NULL,
	img_url		VARCHAR,
	FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE
);

CREATE TABLE user_favorites (
	user_id 	INTEGER NOT NULL,
	product_id 	INTEGER NOT NULL,
	FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE,
	FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE product_rating (
	id 			SERIAL PRIMARY KEY,
	product_id 	INTEGER NOT NULL,
	user_id 	INTEGER NOT NULL,
	rating		INTEGER NOT NULL,
	comment     TEXT,
	FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE,
	FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE orders (
	id 			SERIAL PRIMARY KEY,
	product_id 	INTEGER NOT NULL,
	user_id 	INTEGER NOT NULL,
	quantity 	INTEGER NOT NULL,
	total_price INTEGER NOT NULL,
    order_date  TIMESTAMP,
	status		VARCHAR,
	FOREIGN KEY (product_id) REFERENCES product (id),
	FOREIGN KEY (user_id) REFERENCES users (id)
);



