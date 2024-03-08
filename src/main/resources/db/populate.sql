INSERT INTO users (username, email, us_password)
VALUES 	('John', 'john@gmail.com', 'johnsPassword'),
		('Suarez', 'suarez@gmail.com', 'suarezPassword'),
		('Julia', 'julia@gmail.com', 'juliasPassword'),
		('Funny Shop', 'funny.shop@gmail.com', 'funny1shopsPassword'),
		('Tiffany`s Jewelry', 'tiffanys.jewelry@gmail.com', 'tiffanys1jewelryPassword'),
		('Embroidery Shop', 'embroidery.shop@gmail.com', 'embroidery1shopsPassword'),
		('Leather World', 'leather.world@gmail.com', 'leather1worldPassword');

INSERT INTO user_img (user_id, img_url)
VALUES  (1, 'placeholder'),
		(2, 'placeholder'),
		(3, 'placeholder'),
		(4, 'placeholder'),
		(5, 'placeholder'),
		(6, 'placeholder'),
		(7, 'placeholder');

INSERT INTO roles (name)
VALUES  ('USER'),
        ('ARTIST'),
		('ADMIN');

INSERT INTO user_role (user_id, role_id)
VALUES  (1, 3),
        (1, 1),
		(2, 1),
		(3, 1),
		(4, 2),
		(5, 2),
		(6, 2),
		(7, 2);

INSERT INTO category (name)
VALUES  ('Ceramic'),
		('Wood'),
		('Metal'),
		('Woolen'),
		('Embroidery'),
		('Leather'),
		('Jewelry'),
		('Present'),
		('Glass');
		
INSERT INTO product (creator_id, name,  quantity, price, description)
VALUES  (4, 'Смішна футболка', 10, 600, 'Смішна футболка'),
    	(4, 'Смішна кружка', 5, 280, 'Смішна кружка'),
    	(5, 'Діамантове кольє', 20, 1500, 'Діамантове кольє'),
    	(5, 'Золотий браслет', 15, 1200, 'Золотий браслет'),
    	(6, 'Вишивана подушка', 8, 1000, 'Вишивана подушка'),
    	(6, 'Вишиваний рушник', 12, 550, 'Вишиваний рушник'),
    	(7, 'Шкіряна куртка', 25, 2800, 'Шкіряна куртка'),
    	(7, 'Шкіряна сумка', 18, 1900, 'Шкіряна сумка'),
    	(4, 'Смішна шапка', 30, 150, 'Смішна шапка'),
    	(6, 'Вишивана сукня', 10, 800, 'Вишивана сукня');

INSERT INTO product_img (product_id, img_url)
VALUES  (1, 'placeholder1'),
		(1, 'placeholder2'),
    	(2, 'placeholder1'),
		(2, 'placeholder2'),
    	(3, 'placeholder1'),
		(4, 'placeholder2'),
    	(5, 'placeholder1'),
    	(6, 'placeholder1'),
    	(6, 'placeholder2'),
		(6, 'placeholder3'),
		(6, 'placeholder4'),
    	(7, 'placeholder1'),
    	(8, 'placeholder1'),
    	(9, 'placeholder1'),
    	(10, 'placeholder1');
		
INSERT INTO product_category (product_id, category_id)
VALUES	(1, 8),
    	(2, 1),
		(2, 8),
    	(3, 7),
		(3, 8),
    	(4, 7),
		(4, 8),
    	(5, 5),
    	(6, 5),
    	(7, 6),
    	(8, 6),
    	(9, 8),
    	(10, 5);

INSERT INTO user_favorites (user_id, product_id)
VALUES  (3, 2);

INSERT INTO product_rating  (product_id, user_id, rating, comment)
VALUES  (4, 3, 5, 'Дуже гарний браслет!');

INSERT INTO orders  (product_id, user_id, quantity, total_price, order_date, status)
VALUES  (4, 3, 1, 1200, '2024-01-09 19:10:25', 'COMPLETED'),
		(6, 2, 2, 1100, '2024-02-01 09:00:38', 'IN_PROGRESS'),
		(9, 1, 1, 150, '2024-02-15 21:27:01', 'CANCELED');







