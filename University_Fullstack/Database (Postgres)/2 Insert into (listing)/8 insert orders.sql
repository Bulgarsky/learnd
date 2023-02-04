INSERT INTO orders(order_open, order_price, status_id, order_closed, employee_id)
VALUES
	('2022-01-10 09:00:01', 290, 2, '2022-01-10 09:11:00', 10),
	('2022-01-11 10:09:01', 130, 1, '2022-01-11 10:29:11', 11),
	('2022-02-02 11:00:01', 150, 3, '2022-02-02 11:10:01', 12)
	;
	
SELECT * FROM orders;

SELECT
	id AS номер_заказ,
	order_price AS Общая_сумма
FROM orders
ORDER BY 2 desc;