--The top N populated cities in a distrct
SELECT 
       city.name AS 'city',
       country.name AS 'country',
       city.district,
       city.population
FROM   city
       JOIN country
         ON city.countrycode = country.code
WHERE  district = 'Bretagne'
ORDER  BY population DESC
LIMIT  n ;