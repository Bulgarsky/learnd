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
ORDER BY sallary desc
;