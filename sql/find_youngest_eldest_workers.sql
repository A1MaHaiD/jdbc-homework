SELECT 'YOUNGEST' AS type, name, birthday
FROM worker
WHERE birthday = (SELECT min(birthday) FROM worker)
UNION ALL

SELECT 'ELDEST' AS type, name, birthday
FROM worker
WHERE birthday = (SELECT MAX(birthday) FROM worker)