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