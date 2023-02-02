-- создать таблицу Топпинг_включен_в_заказ
CREATE TABLE topping_included(
	id SERIAL PRIMARY KEY NOT NULL,
	topping_id INT,
	FOREIGN KEY (topping_id) REFERENCES toppings(id),
	order_list_id INT,
	FOREIGN KEY (order_list_id) REFERENCES order_list(id),
	UNIQUE (topping_id, order_list_id)
);

SELECT *
FROM topping_included;