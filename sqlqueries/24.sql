--The population of people, people living in cities, and people not living in cities in each region.
SELECT 
       DISTINCT country.region,
                Sum(DISTINCT country.population) AS 'region population',
                Concat(Round(Sum(DISTINCT city.population) / Sum(DISTINCT
                             country.population) * 100), '%') AS 'urban population %',
                Concat(Round(( Sum(DISTINCT country.population) - Sum(DISTINCT
                                          city.population) ) / Sum(DISTINCT
                             country.population) * 100), '%') AS 'rural population %'
FROM   city
       JOIN country
         ON city.countrycode = country.code
GROUP  BY region; 