--All the countries in a continent organised by largest population to smallest.
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
ORDER  BY population DESC;