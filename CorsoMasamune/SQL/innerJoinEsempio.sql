-- Visualizza l’elenco dei clienti che hanno effettuato almeno un ordine.
select Clienti2.nome, ordini.data_ordine, ordini.importo
from clienti2
inner join ordini on clienti2.id = ordini.id_cliente
order by clienti2.nome asc;

-- Visualizza tutti i clienti, inclusi quelli che non hanno mai effettuato ordini.
select clienti2.nome , ordini.data_ordine, ordini.importo
from clienti2
left join ordini on ordini.id_cliente =  clienti2.id
order by ordini.importo asc;

insert into Ordini(id,id_cliente,data_ordine, importo) values(200,null,"2019-10-01",900);
insert into Ordini(id,id_cliente,data_ordine, importo) values(300,null,"2019-10-01",400); 
--   Visualizza tutti gli ordini, anche quelli che non hanno un cliente associato (caso anomalo).
select  clienti2.nome, ordini.data_ordine, ordini.importo
from clienti2
right join ordini on ordini.id_cliente = clienti2.id
order by ordini.importo asc;

-- Elenca i clienti attivi
SELECT c.nome, COUNT(o.id) AS totale_ordini,SUM(o.importo) AS totale_speso
FROM Clienti2 c
INNER JOIN Ordini o
ON c.id = o.id_cliente
GROUP BY c.id, c.nome;

-- Elenca i clienti inattivi
select c.nome, c.citta, o.importo
from clienti2 c
left join ordini o on o.id_cliente = c.id
where o.id_cliente is null;

-- Individua gli ordini orfani, cioè ordini presenti in tabella ma senza un cliente valido associato
SELECT  o.id AS id_ordine, o.data_ordine, o.importo, c.nome AS cliente
FROM Clienti2 c
RIGHT JOIN Ordini o
ON c.id = o.id_cliente
WHERE c.id IS NULL;

-- prova full join
select c.nome,c.id, o.id,o.importo
from clienti2 c
cross join ordini o on o.id_cliente = c.id;
