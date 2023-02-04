-- Заполнить таблицу topping
INSERT INTO toppings(name, price)
	VALUES
	('солёная карамель', 15),
	('кокос', 10),
	('лесные орехи', 10),
	('мороженное', 10),
	('коньяк', 15)
	;
	
SELECT 
	name AS Название,
	price AS Цена
FROM toppings;