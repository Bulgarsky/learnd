INSERT INTO topping_included(topping_id, order_list_id)
VALUES
	(1, 1), -- заказ1
	(2, 1), -- заказ1
	(3, 2), -- заказ2
	(5, 3) -- заказ3
	;
	
SELECT *
FROM topping_included;