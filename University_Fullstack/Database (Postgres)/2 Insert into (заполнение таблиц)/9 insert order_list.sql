INSERT INTO order_list(beverage_id, order_id, count)
VALUES
	(3, 1, 1), -- заказ1
	(4, 1, 1), -- заказ1
	(2, 2, 1), -- заказ2
	(4, 3, 1) -- заказ3
	;
	
SELECT *
FROM order_list;