-- Создание таблицы Должность
CREATE TABLE employee_position(
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(30) NOT NULL,
	sallary DECIMAL(8, 2) NOT null
);