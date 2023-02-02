INSERT INTO beverage_composition(beverage_id, ingridient_id, volume, volume_type_id)
VALUES
	(1, 4, 20, 1), -- латте, ингридиент 1
	(1, 1, 100, 2), -- латте, ингридиент 2
	(1, 2, 90, 2), --латте, ингридиент 3
	(2, 1, 180, 2), -- эспрессо, ингр 1
	(2, 5, 20, 1), -- эспрессо, ингр 2
	(3, 2, 180, 2), -- американо, ингр 1
	(3, 1, 120, 2), -- американо, ингр 2
	(3, 4, 20, 1),  -- американо, ингр 3
	(4, 1, 60, 2), -- капучино, ингр 1
	(4, 2, 200, 2), -- капучино, ингр 2
	(4, 4, 15, 1) -- капучино, ингр 3
	;

SELECT * 
FROM beverage_composition
ORDER BY beverage_id;