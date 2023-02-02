-- создание таблицы Топпинги:

CREATE TABLE toppings(
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(30) NOT NULL,
	price DECIMAL(8, 2) NOT null
);