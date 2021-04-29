--A list of all the cities in the world organised by largest population to smallest.
SELECT 
       city.name AS 'city',
       country.name AS 'country',
       city.district,
       city.population
FROM   city
       JOIN country
         ON city.countrycode = country.code
ORDER  BY population DESC; 
