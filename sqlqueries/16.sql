--The top N populated cities in a continent where N is provided by the user.
SELECT 
       city.name AS 'city',
       country.name AS 'country',
       city.district,
       city.population
FROM   city
       JOIN country
         ON city.countrycode = country.code
WHERE  continent = 'Europe'
ORDER  BY population DESC
LIMIT  n ;