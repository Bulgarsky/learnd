-- создание таблицы Состав_напитка
CREATE TABLE beverage_composition(
  id SERIAL PRIMARY KEY NOT NULL,
  ingridient_id INTEGER,
  FOREIGN KEY (ingridient_id) REFERENCES ingridients(id),
  beverage_id INTEGER,
  FOREIGN KEY (beverage_id) REFERENCES beverage(id),
  volume INTEGER NOT NULL,
  volume_type_id INTEGER,
  FOREIGN KEY (volume_type_id) REFERENCES volume_type(id),
  UNIQUE(ingridient_id, beverage_id)
  );
  
SELECT *
FROM beverage_composition;