--The population of people, people living in cities, and people not living in cities in each region.
SELECT
       DISTINCT country.region,
       Sum(DISTINCT country.population) AS 'Total Population',
       Concat(Round(Sum(DISTINCT city.population) / Sum(DISTINCT country.population) * 100), '%') AS 'Urban Population',
       Concat(Round(( Sum(DISTINCT country.population) - Sum(DISTINCT city.population) ) / Sum(DISTINCT country.population) * 100), '%') AS 'Rural Population'
FROM   city
       JOIN country
         ON city.countrycode = country.code
GROUP  BY region; 