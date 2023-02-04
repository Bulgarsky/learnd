--Заполнить таблицу Статус заказа
INSERT INTO order_status(name)
VALUES
	('открыт'), 
	('закрыт'),
	('отменен')
	;

SELECT NAME AS Статус_заказа
FROM order_status
ORDER BY 1 ASC;


-- Заполнить таблицу тип объема
INSERT INTO volume_type(name, mesure)
	VALUES
	('сыпучий', 'гр'),
	('жидкий', 'мл'),
	('концентрат', 'мл')
	;
	
SELECT 
	name AS Тип,
	mesure AS Единица_измерения
FROM volume_type
ORDER BY name asc;


-- Заполнить таблицу topping
INSERT INTO toppings(name, price)
	VALUES
	('солёная карамель', 15),
	('кокос', 10),
	('лесные орехи', 10),
	('мороженное', 10),
	('коньяк', 15)
	;
	
SELECT 
	name AS Название,
	price AS Цена
FROM toppings;

-- Заполнить таблицу Должность
INSERT INTO employee_position(name, sallary)
	VALUES
	('Бариста', 18000),
	('Кассир', 17500),
	('Доставщик', 15000),
	('Уборщик', 15000),
	('Руководитель смены', 20000)
	;
	
SELECT 
	name AS Должность,
	sallary AS Зарплата
FROM employee_position
ORDER BY sallary desc;

-- Заполнить таблицу Работники
INSERT INTO employee(name, phone, birthday, position_id)
	VALUES
	('Иванов Сергей Петрович', '+7-900-1111-22-33', '01-01-1970', 1),
	('Самойлова Ирина Владимировна', '+7-999-1111-22-33', '02-08-1980', 1),
	('Ахметова Алина Рафаэловна', '+7-911-1111-22-44', '10-09-1985', 2),
	('Иванов Василий Петрович', '+7-900-1111-22-34', '01-01-1970', 2),
	('Семенов Андрей Владимирович', '+7-922-1111-22-55', '11-12-1985', 3),
	('Гареев Марсель Рифович', '+7-933-1111-22-66', '10-08-1982', 3),
	('Ахметов Евгений Дмитриевич', '+7-911-1111-22-45', '05-05-1984', 4),
	('Приходько Екатерина Генадиевна', '+7-955-1111-22-77', '01-01-1971', 4),
	('Шмидт Александр Генрихович', '+7-999-1111-22-88', '01-01-1966', 5)
	;
	

SELECT * FROM employee;

SELECT
	NAME AS ФИО,
	birthday AS день_рождения
FROM employee
ORDER BY 2 DESC;

-- Заполнить таблицу Напитки
INSERT INTO beverage(name, price, volume, recipe)
	VALUES
	('Латте', 125, 200, 'Заварите крепкий натуральный кофе. 2ч. л. молотого кофе с сахаром залейте 100 мл кипятка и накройте крышкой. Дайте настояться. Взбейте молоко комнатной температуры в пенку. В чашку сначала залейте пену, затем токной струйкой кофе'),
	('Эсперссо', 130, 180, 'Заварите кофе в турке в 60мл воды, затем добавьте еще 120мл воды, дайте настоятся 2-3 минуты, сахар во вкусу'),
	('Американо', 140, 300, 'Заварите кофе в турке в 60мл воды, затем добавьте еще 120мл воды, дайте настоятся 2-3 минуты, добавьте еще 120 мл горячей волы или молока'),
	('Каппучино', 150, 260, 'Завариваем 15гр кофе в турке, подогреваем 200мл молока до 60 градусов и всзбиваем в пену. В стакан наливаем кофе и сразу взбитое молоко')
	;
	
SELECT 
	name AS Название,
	price AS Цена,
	volume AS Объем_напитка
FROM beverage
ORDER BY price desc
;

	
SELECT 
	name AS Название,
	recipe AS Рецепт
FROM beverage
ORDER BY price desc;


--Заполнить таблицу Ингридиенты
INSERT INTO ingridients(name, price)
VALUES
	('вода', 5),
	('молоко', 30),
	('сахар', 10),
	('кофе робуста', 50),
	('кофе арабика', 50),
	('сливки', 20),
	('соль', 1)	
	;

SELECT name AS Ингридиент
FROM ingridients
ORDER BY 1 desc;


-- Заполнить таблицу Заказы
INSERT INTO orders(order_open, order_price, status_id, order_closed, employee_id)
VALUES
	('2022-01-10 09:00:01', 290, 2, '2022-01-10 09:11:00', 10),
	('2022-01-11 10:09:01', 130, 1, '2022-01-11 10:29:11', 11),
	('2022-02-02 11:00:01', 150, 3, '2022-02-02 11:10:01', 12)
	;
	
SELECT * FROM orders;

SELECT
	id AS номер_заказ,
	order_price AS Общая_сумма
FROM orders
ORDER BY 2 desc;

-- Заполнить таблицу Лист_заказа
INSERT INTO order_list(beverage_id, order_id, count)
VALUES
	(3, 1, 1), -- заказ1
	(4, 1, 1), -- заказ1
	(2, 2, 1), -- заказ2
	(4, 3, 1) -- заказ3
	;
	
SELECT *
FROM order_list;


-- Заполнить таблицу Топпинги_в_заказе
INSERT INTO topping_included(topping_id, order_list_id)
VALUES
	(1, 1), -- заказ1
	(2, 1), -- заказ1
	(3, 2), -- заказ2
	(5, 3) -- заказ3
	;
	
SELECT *
FROM topping_included;

-- Заполнить таблицу Состав_напитка
INSERT INTO beverage_composition(beverage_id, ingridient_id, volume, volume_type_id)
VALUES
	(1, 4, 20, 1), -- латте, ингридиент 1
	(1, 1, 100, 2), -- латте, ингридиент 2
	(1, 2, 90, 2), --латте, ингридиент 3
	(2, 1, 180, 2), -- эспрессо, ингр 1
	(2, 5, 20, 1), -- эспрессо, ингр 2
	(3, 2, 180, 2), -- американо, ингр 1
	(3, 1, 120, 2), -- американо, ингр 2
	(3, 4, 20, 1),  -- американо, ингр 3
	(4, 1, 60, 2), -- капучино, ингр 1
	(4, 2, 200, 2), -- капучино, ингр 2
	(4, 4, 15, 1) -- капучино, ингр 3
	;

SELECT * 
FROM beverage_composition
ORDER BY beverage_id;