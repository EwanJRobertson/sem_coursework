--The top N populated countries in a region where N is provided by the user.
SELECT 
       code,
       name,
       continent,
       region,
       population,
       capital
FROM   country
WHERE  region = 'Eastern Europe'
ORDER  BY population DESC
LIMIT  n ;