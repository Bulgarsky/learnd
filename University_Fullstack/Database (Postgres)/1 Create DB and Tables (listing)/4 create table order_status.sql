-- Создание таблицы Статус_заказа
CREATE TABLE order_status(
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(10) NOT NULL
);