INSERT INTO order_status(name)
VALUES
	('открыт'), 
	('закрыт'),
	('отменен')
	;

SELECT NAME AS Статус_заказа
FROM order_status
ORDER BY 1 ASC;
