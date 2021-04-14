--
SELECT 
       continent,
       Sum(population) AS 'population'
FROM   country
WHERE  continent = 'Europe'; 