--The population of a district
SELECT district, SUM(population)
FROM city
WHERE district = 'Bretagne'
;