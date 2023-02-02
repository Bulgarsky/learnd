-- Cоздание таблицы "тип объема"
CREATE TABLE volume_type(
	id serial PRIMARY KEY NOT NULL,
	name VARCHAR(10) NOT NULL,
	mesure VARCHAR(10) NOT null
);

SELECT *
FROM volume_type;