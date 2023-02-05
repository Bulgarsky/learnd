ALTER TABLE passport
ADD opisanie TEXT NULL;

SELECT *
from passport;

ALTER TABLE passport
DROP COLUMN opisanie;
SELECT *
from passport;

alter TABLE passport
ADD descr TEXT NULL;
SELECT *
from passport;

ALTER TABLE passport
RENAME COLUMN descr TO description;

UPDATE passport
SET description='Проверить срок действия паспорта'
WHERE passport_id=10 or passport_id=13 OR passport_id=17;

SELECT *
from passport;

SELECT
	employee.name AS Сотрудник,
	passport.series AS Серия_Паспорта,
	passport.number AS Номер_Паспорта,
	passport.description AS Примечание
from employee
LEFT JOIN passport ON employee.id = passport.passport_id
ORDER BY 1 desc
;

SELECT
	employee.name AS Сотрудник,
	passport.series AS Серия_Паспорта,
	passport.number AS Номер_Паспорта,
	passport.description AS Примечание
from employee
LEFT JOIN passport ON employee.id = passport.passport_id
WHERE passport.description is null
ORDER BY 1 desc
;

UPDATE passport
SET description='Паспорт в порядке'
WHERE description IS NULL;

SELECT
	employee.name AS Сотрудник,
	passport.series AS Серия_Паспорта,
	passport.number AS Номер_Паспорта,
	passport.description AS Примечание
from employee
LEFT JOIN passport ON employee.id = passport.passport_id
ORDER BY 1 ASC;

BEGIN;
ALTER TABLE toppings
RENAME COLUMN name TO item;

ALTER TABLE volume_type
RENAME COLUMN name TO item;

ALTER TABLE employee_position
RENAME COLUMN name TO item;

ALTER TABLE order_status
RENAME COLUMN name TO item;

ALTER TABLE ingridients
RENAME COLUMN name TO item;

ALTER TABLE beverage
RENAME COLUMN name TO item;

SAVEPOINT NAME2item;

ALTER TABLE employee_position
RENAME COLUMN sallary TO salary;

ALTER TABLE order_list
RENAME TO order_items;

COMMIT;

CREATE TABLE employee_status(
	id SERIAL PRIMARY key NOT NULL,
	item VARCHAR(20) NOT NULL
	);

INSERT INTO employee_status(item)
VALUES
	('Работает'),
	('Уволен'),
	('Больничный');
	
SELECT item AS Статус
FROM employee_status;

DELETE FROM employee_status;
SELECT item AS Статус
FROM employee_status;


DROP TABLE employee_status;


CREATE TABLE employee_status(
	id SERIAL PRIMARY key NOT NULL,
	item VARCHAR(20) NOT NULL
	);

ALTER TABLE employee_status
ADD COLUMN description TEXT NULL;

INSERT INTO employee_status(item)
VALUES
	('Работает'),
	('Уволен'),
	('Уволился'),
	('Больничный');
	
SELECT item AS Статус
FROM employee_status;

