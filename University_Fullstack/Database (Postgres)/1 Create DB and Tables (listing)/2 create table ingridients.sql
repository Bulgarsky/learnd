-- Создание таблицы Ингридиенты:

CREATE TABLE ingridients(
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(30) NOT NULL,
	price DECIMAL(8, 2)
	);

SELECT *
FROM ingridients;