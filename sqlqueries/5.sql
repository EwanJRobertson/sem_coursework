--The top N populated countries in a continent where N is provided by the user.
SELECT 
       code,
       name,
       continent,
       region,
       population,
       capital
FROM   country
WHERE  continent = 'Europe'
ORDER  BY population DESC
LIMIT  n ;