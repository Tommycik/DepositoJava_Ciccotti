USE `world`;
-- view città italiane
create or replace view italianCities as
select *
from city
where countrycode = 'ITA';

select *
from italianCities
where population < 100000;
