--All the countries in the world organised by largest population to smallest.
SELECT 
       code,
       (country.name) AS 'Country Name',
       continent,
       region,
       country.population,
       city.name AS 'Capital City'
FROM   country
       JOIN city
         ON country.capital = city.ID 
ORDER  BY country.population DESC; 