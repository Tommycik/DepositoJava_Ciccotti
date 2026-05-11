use venditeLibri;
-- Visualizzare l’elenco dei libri venduti in almeno un negozio
select l.titolo, l.autore, v.data_vendita, v.negozio
FROM Libri l
INNER JOIN Vendite v
ON l.id = v.id_libro
WHERE LOWER(l.autore) LIKE '%king%';

-- Visualizzare tutti i libri, anche quelli che non hanno ancora vendite registrate
SELECT l.titolo, l.anno_pubblicazione, l.prezzo, v.data_vendita
FROM Libri l
LEFT JOIN Vendite v
ON l.id = v.id_libro
WHERE l.anno_pubblicazione BETWEEN 2000 AND 2010;

-- Visualizzare i dati dei libri venduti nei negozi appartenenti a una lista specifica
SELECT l.titolo, v.negozio, v.quantita, (v.quantita * l.prezzo) AS prezzo_totale
FROM Libri l
INNER JOIN Vendite v
ON l.id = v.id_libro
WHERE v.negozio IN (
    '9 Oriole Lane',
    '98558 Milwaukee Point',
    '98016 Esch Trail'
);

-- Mostrare tutti i record di vendita, anche quelli che fanno riferimento a libri non più presenti nella tabella Libri (caso anomalo)
SELECT l.titolo, v.data_vendita, l.prezzo, v.quantita
FROM Libri l
RIGHT JOIN Vendite v
ON l.id = v.id_libro
WHERE v.data_vendita BETWEEN '2020-01-01' AND '2022-12-31'
AND LOWER(v.negozio) LIKE '%drive%';

-- Mostrare titolo, autore, prezzo e data_vendita dei libri con genere IN (‘Fantasy’, ‘Horror’, ‘Drama’) (ignora i libri con >1 genere)
SELECT  l.titolo, l.autore, l.prezzo, v.data_vendita
FROM Libri l
INNER JOIN Vendite v
ON l.id = v.id_libro
WHERE l.genere IN ('Fantasy', 'Horror', 'Drama')
AND v.data_vendita > 2015
AND LOWER(v.negozio) LIKE '%plaza%'
ORDER BY l.anno_pubblicazione DESC;

