USE `world`;
-- lingue parlate con pecentuale
select co.name as country,cl.language as language, cl.percentage
from Country as co
inner join countrylanguage as cl on co.code = cl.countrycode
order by co.name,cl.Percentage;

-- nazioni e percentuale lingua più parlata
select co.name as country,max(cl.percentage) as max_percentage
FROM country co
INNER JOIN countrylanguage cl
    ON co.Code = cl.CountryCode
group by co.name
ORDER BY co.Name;

-- subquery
-- nazioni e percentuale lingua più parlata
select co.name as country,cl.language,cl.percentage
FROM((country as co
INNER JOIN countrylanguage cl
    ON co.Code = cl.CountryCode) inner join(
		SELECT CountryCode, MAX(Percentage) AS MaxPerc
		FROM countrylanguage
		GROUP BY CountryCode) as sub on co.code = sub.countrycode and sub.maxPerc = cl.percentage)
ORDER BY co.Name;

