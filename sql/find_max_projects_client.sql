SELECT client.name, count(project.client_id) AS project_count
FROM client
LEFT JOIN project ON client.id = project.client_id
GROUP BY client.name
ORDER BY project_count DESC
LIMIT 1;