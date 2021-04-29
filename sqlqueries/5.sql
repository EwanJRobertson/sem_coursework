--The top N populated countries in a continent where N is provided by the user.
SELECT 
       code,
       country.name AS 'country',
       continent,
       region,
       country.population,
       city.name AS 'capital'
FROM   country
       JOIN city
         ON country.capital = city.ID 
WHERE  continent = 'Europe'
ORDER  BY population DESC
LIMIT  n ;