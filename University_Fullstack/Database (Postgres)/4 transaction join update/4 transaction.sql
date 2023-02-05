SELECT
	employee.name AS Работник,
	employee_position.name AS Должность,
	employee_position.sallary AS Зарплата,
	passport.address AS Адрес_проживания
FROM employee
LEFT JOIN employee_position ON employee.position_id = employee_position.id
LEFT JOIN passport ON employee.id = passport.passport_id
LIMIT 2
OFFSET 2;

SELECT * FROM employee
ORDER BY id asc;
-- Найдено: лишняя цифра в номере телефона
UPDATE employee
SET phone = '+7-900-111-22-33'
WHERE id =10;


ROLLBACK;

BEGIN;
UPDATE employee
SET phone = '+7-999-111-22-33'
WHERE id =11;
UPDATE employee
SET phone = '+7-911-111-22-44'
WHERE id =12;
UPDATE employee
SET phone = '+7-900-111-22-34'
WHERE id =13;
UPDATE employee
SET phone = '+7-922-111-22-55'
WHERE id =14;

SAVEPOINT update_phones;

SELECT * FROM employee
ORDER BY id ASC;

BEGIN;
UPDATE employee
SET phone = '+7-922-111-22-66'
WHERE id =14;

SELECT * FROM employee
ORDER BY id ASC;


-- Введен неверный номер телефона по id=14
ROLLBACK TO update_phones;
SELECT * FROM employee
ORDER BY id ASC;

BEGIN;
UPDATE employee
SET phone = '+7-933-111-22-66'
WHERE id =15;

UPDATE employee
SET phone = '+7-911-111-22-45'
WHERE id =16;

UPDATE employee
SET phone = '+7-955-111-22-77'
WHERE id =17;

UPDATE employee
SET phone = '+7-999-111-22-88'
WHERE id =18;

SELECT * FROM employee
ORDER BY id ASC;

SAVEPOINT update_phones_2;
COMMIT;
SELECT * FROM employee
ORDER BY id ASC;

-- добавление маски ввода для поля телефон
ALTER TABLE employee
ADD CHECK (phone SIMILAR TO '\+7-[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]');

BEGIN;
UPDATE employee
SET phone = '+7-999-1112-2-88'
WHERE id =18;
ROLLBACK;
COMMIT;