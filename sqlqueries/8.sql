--All the cities in a continent organised by largest population to smallest.
SELECT 
       city.name AS 'city',
       country.name AS 'country',
       city.district,
       city.population
FROM   city
       JOIN country
         ON city.countrycode = country.code
WHERE  continent = 'Europe'
ORDER  BY population DESC;