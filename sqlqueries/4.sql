--The top N populated countries in the world where N is provided by the user.
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
ORDER  BY population DESC
LIMIT  n ;