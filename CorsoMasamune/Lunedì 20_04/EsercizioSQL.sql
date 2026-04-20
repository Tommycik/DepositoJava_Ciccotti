USE world;

SELECT DISTINCT Region
FROM Country
WHERE Continent = 'Europe';

SELECT Name , Population
FROM country
WHERE Region = 'Southern Europe' and Population > 25000
order by Population desc;

select Continent, count(*) as numCountries, sum(Population) as totalPopulation
from country
group by Continent
order by TotalPopulation  desc
