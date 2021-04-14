--The population of a district
SELECT 
       district,
       Sum(population) AS 'population'
FROM   city
WHERE  district = 'Bretagne'; 