--All the capital cities in a continent organised by largest population to smallest.
SELECT 
       city.name AS 'city',
       country.name AS 'country',
       city.population
FROM   city
       JOIN country
         ON city.id = country.capital
WHERE  continent = 'Europe'
ORDER  BY population DESC;