-- добавить таблицу паспорт
CREATE TABLE passport(
	passport_id INT,
	FOREIGN KEY (passport_id) REFERENCES employee(id),
	series VARCHAR(4),
	number VARCHAR(6),
	issued_date DATE,
	issued_gov VARCHAR(50),
	address VARCHAR(100),
	UNIQUE (passport_id)
);

SELECT * FROM passport;
SELECT * FROM employee;

-- заполнить таблицу паспорт
INSERT into passport(passport_id, series, number, issued_date, issued_gov, address)
VALUES
	(10, 1000, 123123, '2020-01-05', 'МВД России', 'Москва'),
	(11, 1000, 222555, '2010-01-10', 'МВД России', 'Казань'),
	(12, 2000, 123123, '2005-01-05', 'Отдел Миграции', 'Москва'),	
	(13, 2000, 444444, '2009-01-05', 'МФЦ', 'Пермь'),
	(14, 3000, 123123, '2000-01-05', 'МВД России', 'Новосибирск'),
	(15, 3000, 555555, '2012-01-05', 'МВД России', 'Елабуга'),
	(16, 6000, 222222, '2008-01-02', 'Отдел Миграции', 'Новосибирск'),
	(17, 6000, 111111, '2021-02-01', 'МФЦ', 'Уфа'),
	(18, 6000, 333333, '2022-03-15', 'МВД России', 'Новосибирск');

SELECT * FROM passport;
SELECT * FROM employee;
SELECT * FROM employee_position;

SELECT
	employee.name AS Работник,
	employee_position.name AS Должность,
	employee_position.sallary AS Зарплата,
	passport.address AS Адрес_проживания
FROM employee
LEFT JOIN employee_position ON employee.position_id = employee_position.id
LEFT JOIN passport ON employee.id = passport.passport_id
WHERE passport.address LIKE 'Москва'
;

SELECT
	employee.name AS Работник,
	employee_position.name AS Должность,
	employee_position.sallary AS Зарплата,
	passport.address AS Адрес_проживания
FROM employee
LEFT JOIN employee_position ON employee.position_id = employee_position.id
LEFT JOIN passport ON employee.id = passport.passport_id
WHERE passport.address LIKE 'Новосибирск'
ORDER BY 1 asc
;

SELECT * FROM beverage;
SELECT * FROM beverage_composition;
SELECT * FROM ingridients;
SELECT * FROM volume_type;


SELECT 
	beverage.name AS Напиток,
	beverage.price AS Цена,
	ingridients.name AS Ингридиент,
	beverage_composition.volume AS Объем_ингридиента,
	volume_type.mesure AS Единица_измерения
FROM beverage
LEFT JOIN beverage_composition ON beverage.id = beverage_composition.beverage_id
LEFT JOIN ingridients ON beverage_composition.ingridient_id = ingridients.id
LEFT JOIN volume_type ON beverage_composition.volume_type_id = volume_type.id;


SELECT 
	beverage.name AS Напиток,
	beverage.price AS Цена,
	ingridients.name AS Ингридиент,
	beverage_composition.volume AS Объем_ингридиента,
	volume_type.mesure AS Единица_измерения
FROM beverage
LEFT JOIN beverage_composition ON beverage.id = beverage_composition.beverage_id
LEFT JOIN ingridients ON beverage_composition.ingridient_id = ingridients.id
LEFT JOIN volume_type ON beverage_composition.volume_type_id = volume_type.id
WHERE beverage.name LIKE 'Американо'
;

SELECT 
	beverage.name AS Напиток,
	beverage.price AS Цена,
	ingridients.name AS Ингридиент,
	beverage_composition.volume AS Объем_ингридиента,
	volume_type.mesure AS Единица_измерения
FROM beverage
LEFT JOIN beverage_composition ON beverage.id = beverage_composition.beverage_id
LEFT JOIN ingridients ON beverage_composition.ingridient_id = ingridients.id
LEFT JOIN volume_type ON beverage_composition.volume_type_id = volume_type.id
WHERE ingridients.name LIKE 'вода' and beverage.price <= 140
;


SELECT 
	beverage.name AS Напиток,
	beverage.price AS Цена_Напитка,
	order_list.count AS Количество,
	orders.order_price AS Общая_Цена,
	order_status.name AS Статус_заказа
FROM order_list
LEFT JOIN beverage ON order_list.beverage_id = beverage.id
LEFT JOIN orders ON order_list.order_id = orders.id
LEFT JOIN order_status ON orders.status_id = order_status.id
;

SELECT 
	orders.id AS Номер_заказа,
	beverage.name AS Напиток,
	order_list.count AS Количество_напитков,
	beverage.price AS Цена_Напитка,
	orders.order_price AS Общая_Цена,
	order_status.name AS Статус_заказа,
	employee.name AS Сотрудник
FROM order_list
LEFT JOIN beverage ON order_list.beverage_id = beverage.id
LEFT JOIN orders ON order_list.order_id = orders.id
LEFT JOIN order_status ON orders.status_id = order_status.id
LEFT JOIN employee ON orders.employee_id = employee.id
;

SELECT 
	orders.id AS Номер_заказа,
	orders.order_price AS Общая_Цена,
	order_status.name AS Статус_заказа,
	employee.name AS Сотрудник
FROM order_list
LEFT JOIN beverage ON order_list.beverage_id = beverage.id
LEFT JOIN orders ON order_list.order_id = orders.id
LEFT JOIN order_status ON orders.status_id = order_status.id
LEFT JOIN employee ON orders.employee_id = employee.id
WHERE order_status.name LIKE 'закрыт'
	AND orders.order_price > 200
ORDER BY 1;
;

SELECT 
	orders.id AS Номер_заказа,
	orders.order_price AS Общая_Цена,
	order_status.name AS Статус_заказа,
	employee.name AS Сотрудник
FROM order_list
LEFT JOIN beverage ON order_list.beverage_id = beverage.id
LEFT JOIN orders ON order_list.order_id = orders.id
LEFT JOIN order_status ON orders.status_id = order_status.id
LEFT JOIN employee ON orders.employee_id = employee.id
;


SELECT 
	NAME AS ФИО,
	phone AS Номер_телефона
FROM employee
WHERE phone SIMILAR TO '%999%';

SELECT 
	NAME AS ФИО,
	phone AS Номер_телефона
FROM employee
WHERE name SIMILAR TO 'Ахм%';

SELECT
	employee.name AS Сотрудник,
	employee.phone AS номер_телефона,
	employee_position.name AS Должность,
	employee_position.sallary AS Зарплата
FROM employee
RIGHT JOIN employee_position ON employee.position_id = employee_position.id
;

SELECT
	employee.name AS Сотрудник,
	employee.phone AS номер_телефона,
	employee_position.name AS Должность,
	employee_position.sallary AS Зарплата
FROM employee
RIGHT JOIN employee_position ON employee.position_id = employee_position.id
WHERE employee_position.sallary <= 18000
	AND employee.name LIKE '%Влад%'
	AND employee.phone SIMILAR TO '%22%'
;

