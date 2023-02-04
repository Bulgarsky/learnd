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