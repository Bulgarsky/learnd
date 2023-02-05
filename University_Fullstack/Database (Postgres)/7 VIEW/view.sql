CREATE VIEW all_orders AS
SELECT 
	orders.id AS Номер_заказа,
	beverage.item AS Напиток,
	order_items.count AS Количество_напитков,
	beverage.price AS Цена_Напитка,
	orders.order_price AS Общая_Цена,
	order_status.item AS Статус_заказа,
	employee.name AS Сотрудник
FROM order_items
LEFT JOIN beverage ON order_items.beverage_id = beverage.id
LEFT JOIN orders ON order_items.order_id = orders.id
LEFT JOIN order_status ON orders.status_id = order_status.id
LEFT JOIN employee ON orders.employee_id = employee.id
;
SELECT * FROM all_orders;

CREATE VIEW  salary_below_avg as
SELECT employee.name AS "Сотрудник",
    employee.phone AS "номер_телефона",
    employee_position.item AS "Должность",
    employee_position.salary AS "Зарплата"
FROM employee
RIGHT JOIN employee_position ON employee.position_id = employee_position.id
WHERE salary < (
	SELECT avg(salary) FROM employee_position
	)
ORDER BY employee.name DESC;

SELECT * FROM salary_below_avg;


CREATE VIEW employee_from_msk as
 SELECT employee.name AS "Работник",
    employee_position.item AS "Должность",
    employee_position.salary AS "Зарплата",
    passport.address AS "Адрес_проживания"
FROM employee
LEFT JOIN employee_position ON employee.position_id = employee_position.id
LEFT JOIN passport ON employee.id = passport.passport_id
WHERE passport.address= 'Москва';
SELECT * FROM employee_from_msk


CREATE VIEW beverage_composition_all as
 SELECT beverage.item AS "Напиток",
    ingridients.item AS "Ингридиент",
    beverage_composition.volume AS "Объем_ингридиента",
    volume_type.mesure AS "Единица_измерения"
FROM beverage
LEFT JOIN beverage_composition ON beverage.id = beverage_composition.beverage_id
LEFT JOIN ingridients ON beverage_composition.ingridient_id = ingridients.id
LEFT JOIN volume_type ON beverage_composition.volume_type_id = volume_type.id;
SELECT * FROM beverage_composition_all;


CREATE beverage_latte as
SELECT
	ingridients.item AS "Ингридиент",
	 beverage_composition.volume AS "Объем_ингридиента",
	volume_type.mesure AS "Единица_измерения"
FROM beverage
LEFT JOIN beverage_composition ON beverage.id = beverage_composition.beverage_id
LEFT JOIN ingridients ON beverage_composition.ingridient_id = ingridients.id
LEFT JOIN volume_type ON beverage_composition.volume_type_id = volume_type.id
WHERE beverage.item = 'Латте';

SELECT * FROM beverage_latte;