--All the countries in the world organised by largest population to smallest.
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
ORDER  BY population DESC; 