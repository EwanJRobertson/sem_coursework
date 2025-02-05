--The top N populated capital cities in the world where N is provided by the user.
SELECT 
       city.name AS 'city',
       country.name AS 'country',
       city.population
FROM   city
       JOIN country
         ON city.id = country.capital
ORDER  BY population DESC
LIMIT  n ; 