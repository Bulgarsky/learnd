-- Создание базы данных:
CREATE DATABASE Coffee_shop;

-- Cоздание таблицы "тип объема"
CREATE TABLE volume_type(
	id serial PRIMARY KEY NOT NULL,
	name VARCHAR(10) NOT NULL,
	mesure VARCHAR(10) NOT null
);

SELECT *
FROM volume_type;


-- Создание таблицы Ингридиенты:
CREATE TABLE ingridients(
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(30) NOT NULL,
	price DECIMAL(8, 2)
	);

SELECT *
FROM ingridients;

-- создание таблицы Топпинги:
CREATE TABLE toppings(
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(30) NOT NULL,
	price DECIMAL(8, 2) NOT null
);

-- Создание таблицы Статус_заказа
CREATE TABLE order_status(
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(10) NOT NULL
);


-- Создание таблицы Должность
CREATE TABLE employee_position(
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(30) NOT NULL,
	sallary DECIMAL(8, 2) NOT null
);

-- Создание таблицы Напитки
CREATE TABLE beverage(
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(30) NOT NULL,
	price DECIMAL(8, 2) NOT NULL,
	volume INT NOT NULL,
	recipe TEXT NULL
);


-- Создать таблицу Работник
CREATE TABLE employee(
	id SERIAL PRIMARY KEY NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	phone VARCHAR(17) NOT NULL, -- нужна маска ввода [+7-___-___-__-__]
	birthday DATE NOT NULL,
	position_id INT,
	FOREIGN KEY (position_id) REFERENCES employee_position(id)
	);
	
SELECT *
FROM employee;

-- создание таблицы Состав_напитка
CREATE TABLE beverage_composition(
  id SERIAL PRIMARY KEY NOT NULL,
  ingridient_id INTEGER,
  FOREIGN KEY (ingridient_id) REFERENCES ingridients(id),
  beverage_id INTEGER,
  FOREIGN KEY (beverage_id) REFERENCES beverage(id),
  volume INTEGER NOT NULL,
  volume_type_id INTEGER,
  FOREIGN KEY (volume_type_id) REFERENCES volume_type(id),
  UNIQUE(ingridient_id, beverage_id)
  );
  
SELECT *
FROM beverage_composition;

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