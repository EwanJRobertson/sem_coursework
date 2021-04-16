--The population of a region
SELECT 
       Sum(population) AS 'population'
FROM   country
WHERE  region = 'Western Europe'; 