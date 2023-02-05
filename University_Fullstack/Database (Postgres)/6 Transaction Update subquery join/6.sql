INSERT INTO employee_position(item, salary)
VALUES 
	('директор', 100000),
	('специалист по найму', 25000);

SELECT
	item AS Должность,
	salary AS Оклад
FROM employee_position;

SELECT COUNT(item) AS Должностей
FROM employee_position;
--7

ROLLBACK;
BEGIN;
UPDATE employee_position
SET salary = salary + 5000
WHERE item NOT LIKE 'директор';

UPDATE employee_position
SET salary = salary - (7*5000)
WHERE item = 'директор';

SELECT
	item AS Должность,
	salary AS Оклад
FROM employee_position;
COMMIT;

SELECT ROUND(AVG(salary),2)
FROM employee_position;

INSERT INTO FROM employee_position(item, salary)
VALUES
	('менеджер звена', (SELECT ROUND(AVG(salsry),2) FROM FROM employee_position));

SELECT
	item AS Должность,
	salary AS Оклад
FROM employee_position;


SELECT 
	SUM(salary) AS зарплатный_фондж

SELECT
	SUM(order_price) AS Общий_чек
FROM orders;

SELECT
	item AS Должность,
	salary AS Оклад
FROM employee_position
WHERE salary > (
	SELECT AVG(salary) FROM employee_position
	)
ORDER BY 2 DESC;

SELECT
	item AS Должность,
	salary AS Оклад
FROM employee_position
WHERE salary < (
	SELECT AVG(salary) FROM employee_position
	)
ORDER BY 2 ASC;

SELECT
	employee.name AS Сотрудник,
	employee.phone AS номер_телефона,
	employee.item AS Должность,
	employee.salary AS Зарплата
FROM employee_position
LEFT JOIN employee_position ON employee.position_id = employee_position.id
WHERE salary < (
	SELECT AVG(salary) FROM employee_position
	)
ORDER BY 2 ASC;


SELECT
	employee.name AS Сотрудник,
	employee.phone AS номер_телефона,
	employee.item AS Должность,
	employee.salary AS Зарплата
FROM employee_position
LEFT JOIN employee_position ON employee.position_id = employee_position.id
WHERE salary > (
	SELECT AVG(salary) FROM employee_position
	)
ORDER BY 4 DESC;


SELECT
	employee.name AS Сотрудник,
	employee.phone AS номер_телефона,
	employee.item AS Должность,
	employee.salary AS Зарплата
FROM employee_position
RIGHT JOIN employee_position ON employee.position_id = employee_position.id
ORDER BY 3 ASC;


SELECT
	employee.name AS Сотрудник,
	employee.phone AS номер_телефона,
	employee.item AS Должность,
	employee.salary AS Зарплата
FROM employee_position
RIGHT JOIN employee_position ON employee.position_id = employee_position.id
WHERE salary = (
	SELECT min(salary) FROM employee_position
	)
ORDER BY 1 DESC;

SELECT
	employee.name AS Сотрудник,
	employee.phone AS номер_телефона,
	employee.item AS Должность,
	employee.salary AS Зарплата
FROM employee_position
RIGHT JOIN employee_position ON employee.position_id = employee_position.id
WHERE salary = (
	SELECT max(salary) FROM employee_position
	)
ORDER BY 1 DESC;

SELECT DISTINCT salary FROM employee_position;