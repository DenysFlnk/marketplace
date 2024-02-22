INSERT INTO users (id, username, email, us_password)
VALUES 	(1, 'John', 'john@gmail.com', 'johnsPassword'),
		(2, 'Suarez', 'suarez@gmail.com', 'suarezPassword'),
		(3, 'Julia', 'julia@gmail.com', 'juliasPassword'),
		(4, 'Funny Shop', 'funny.shop@gmail.com', 'funny1shopsPassword'),
		(5, 'Tiffany`s Jewelry', 'tiffanys.jewelry@gmail.com', 'tiffanys1jewelryPassword'),
		(6, 'Embroidery Shop', 'embroidery.shop@gmail.com', 'embroidery1shopsPassword'),
		(7, 'Leather World', 'leather.world@gmail.com', 'leather1worldPassword');

INSERT INTO user_img (id, user_id, img_url)
VALUES  (1, 1, 'placeholder'),
		(2, 2, 'placeholder'),
		(3, 3, 'placeholder'),
		(4, 4, 'placeholder'),
		(5, 5, 'placeholder'),
		(6, 6, 'placeholder'),
		(7, 7, 'placeholder');

INSERT INTO roles (id, name)
VALUES  (1, 'USER'),
		(2, 'ADMIN');

INSERT INTO user_role (user_id, role_id)
VALUES  (1, 2),
		(2, 1),
		(3, 1),
		(4, 1),
		(5, 1),
		(6, 1),
		(7, 1);

INSERT INTO category (id, name)
VALUES  (1, 'Ceramic'),
		(2, 'Wood'),
		(3, 'Metal'),
		(4, 'Woolen'),
		(5, 'Embroidery'),
		(6, 'Leather'),
		(7, 'Jewelry'),
		(8, 'Present'),
		(9, 'Glass');
		
INSERT INTO product (id, creator_id, quantity, price, description)
VALUES  (1, 4, 10, 600, 'Смішна футболка'),
    	(2, 4, 5, 280, 'Смішна кружка'),
    	(3, 5, 20, 1500, 'Діамантове кольє'),
    	(4, 5, 15, 1200, 'Золотий браслет'),
    	(5, 6, 8, 1000, 'Вишивана подушка'),
    	(6, 6, 12, 550, 'Вишиваний рушник'),
    	(7, 7, 25, 2800, 'Шкіряна куртка'),
    	(8, 7, 18, 1900, 'Шкіряна сумка'),
    	(9, 4, 30, 150, 'Смішна шапка'),
    	(10, 6, 10, 800, 'Вишивана сукня');

INSERT INTO product_img (id, product_id, img_url)
VALUES  (1, 1, 'placeholder1'),
		(2, 1, 'placeholder2'),
    	(3, 2, 'placeholder1'),
		(4, 2, 'placeholder2'),
    	(5, 3, 'placeholder1'),
		(6, 4, 'placeholder2'),
    	(7, 5, 'placeholder1'),
    	(8, 6, 'placeholder1'),
    	(9, 6, 'placeholder2'),
		(10, 6, 'placeholder3'),
		(11, 6, 'placeholder4'),
    	(12, 7, 'placeholder1'),
    	(13, 8, 'placeholder1'),
    	(14, 9, 'placeholder1'),
    	(15, 10, 'placeholder1');
		
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

INSERT INTO product_rating  (id, product_id, user_id, rating, comment)
VALUES  (1, 4, 3, 5, 'Дуже гарний браслет!');

INSERT INTO orders  (id, product_id, user_id, quantity, total_price, order_date, status)
VALUES  (1, 4, 3, 1, 1200, '2024-01-09 19:10:25', 'COMPLETED'),
		(2, 6, 2, 2, 1100, '2024-02-01 09:00:38', 'IN_PROGRESS'),
		(3, 9, 1, 1, 150, '2024-02-15 21:27:01', 'CANCELED');







