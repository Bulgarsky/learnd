-- Создание таблицы Заказы
CREATE TABLE orders(
	id SERIAL PRIMARY KEY NOT NULL,
	order_open TIMESTAMP NOT NULL,
	order_price DECIMAL(8, 2) NOT NULL,
	status_id INT,
	FOREIGN KEY (status_id) REFERENCES order_status(id),
	order_closed TIMESTAMP NULL,
	employee_id INT,
	FOREIGN KEY (employee_id) REFERENCES employee(id)
	);

SELECT *
FROM orders;