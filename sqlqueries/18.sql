--The top N populated cities in a country
SELECT 
       city.name AS 'city',
       country.name AS 'country',
       city.district,
       city.population
FROM   city
       JOIN country
         ON city.countrycode = country.code
WHERE  country.name = 'France'
ORDER  BY population DESC
LIMIT  n ;