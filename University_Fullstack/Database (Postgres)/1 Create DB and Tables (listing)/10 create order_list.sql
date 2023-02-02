-- Создать таблицу Лист_заказа:
CREATE TABLE order_list(
	id SERIAL PRIMARY KEY NOT NULL,
	beverage_id INT,
	FOREIGN KEY (beverage_id) REFERENCES beverage(id),
	order_id INT,
	FOREIGN KEY (order_id) REFERENCES orders(id),
	count INT NOT NULL
);

SELECT *
FROM order_list;