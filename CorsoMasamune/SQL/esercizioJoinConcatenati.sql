USE `world`;
-- lingua e nazione di ogni citta
Select ci.name as city,co.name as country , cl.language as language
from ((City as ci
inner join Country as co on ci.CountryCode = co.code)
inner join countryLanguage as cl on co.code = cl.CountryCode);

-- numero di città per nazione
Select co.name as Country, count(ci.name) as cities
from Country as co
inner join City as ci on ci.countrycode=co.code
group by co.name
order by cities asc;

-- lista di repubbliche con aspettativa di vita maggiore di 70
Select co.name,co.GovernmentForm, cl.language,co.LifeExpectancy
from Country as co 
inner join CountryLanguage as cl on co.code = cl.Countrycode
where co.LifeExpectancy > 70 and LOWER(co.GovernmentForm) LIKE'%republic%';
