SELECT id, DATEDIFF(month, start_date, finish_date) AS month_count
FROM project
WHERE DATEDIFF(month, start_date, finish_date) = (
    SELECT max(DATEDIFF(month, start_date, finish_date))
    FROM project
);