SELECT name, city, per_diem, date_first, date_last
FROM trip
WHERE name LIKE '%а__._.'
ORDER BY date_last DESC;

