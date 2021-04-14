-- This will display the percentage of the population of the world which speak either Chinese, English, Hindi, Spanish or Arabic
SELECT 
       DISTINCT countrylanguage.language,
                Sum(countrylanguage.percentage / 100 * country.population) AS 'No. of People',
                ( Sum(countrylanguage.percentage / 100 * country.population) /
                    (SELECT Sum(population)
                    FROM   country)
                  * 100 ) AS '% of World'
FROM   countrylanguage
       JOIN country
         ON countrylanguage.countrycode = country.code
WHERE  language IN ( 'chinese', 'english', 'hindi', 'spanish', 'arabic' )
GROUP  BY language; 