USE world;

-- Mostra regioni in europa
SELECT DISTINCT Region
FROM Country
WHERE Continent = 'Europe';

-- Mostra le nazioni e la loro popolazione selezionate
SELECT Name , Population
FROM country
WHERE Region = 'Southern Europe' and Population > 25000
order by Population desc;

-- Mostra per ogni continente il numero di nazioni e la popolazione totale
select Continent, count(*) as numCountries, sum(Population) as totalPopulation
from country
group by Continent
order by TotalPopulation  desc
