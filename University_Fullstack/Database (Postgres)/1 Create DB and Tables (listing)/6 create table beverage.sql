-- Создание таблицы Напитки
CREATE TABLE beverage(
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(30) NOT NULL,
	price DECIMAL(8, 2) NOT NULL,
	volume INT NOT NULL,
	recipe TEXT NULL
);