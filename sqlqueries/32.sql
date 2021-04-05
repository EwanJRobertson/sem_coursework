-- This will display the percentage of the population of the world which speak either Chinese, English, Hindi, Spanish or Arabic
SELECT DISTINCT countrylanguage.Language, SUM(countrylanguage.Percentage/100*country.Population), (SUM(countrylanguage.Percentage/100*country.Population)/(SELECT SUM(population) FROM country)*100) 
FROM countrylanguage JOIN country ON countryLanguage.countrycode=country.code
WHERE language in ('chinese', 'english', 'hindi', 'spanish', 'arabic')
GROUP BY language
;