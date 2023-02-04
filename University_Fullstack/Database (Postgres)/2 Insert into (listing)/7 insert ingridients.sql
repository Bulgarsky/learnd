INSERT INTO ingridients(name, price)
VALUES
	('вода', 5),
	('молоко', 30),
	('сахар', 10),
	('кофе робуста', 50),
	('кофе арабика', 50),
	('сливки', 20),
	('соль', 1)	
	;

SELECT name AS Ингридиент
FROM ingridients
ORDER BY 1 desc;
