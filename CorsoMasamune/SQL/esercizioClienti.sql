-- clienti con email con email simile
SELECT *
FROM Clienti
WHERE email LIKE '%@google.%';

-- clienti con email con parte finale particolare
SELECT *
FROM Clienti
WHERE email LIKE '%@shinystat.com';

-- clienti con nome che inizia con A
SELECT *
FROM Clienti
WHERE nome LIKE 'A%';

-- clienti con cognome di 5 caratteri
SELECT *
FROM Clienti
WHERE cognome LIKE "_____";

-- clienti con età compresa in un range
SELECT *
FROM Clienti
WHERE eta BETWEEN 30 AND 40;

-- clienti in una determinata citta
SELECT *
FROM Clienti
WHERE LOWER(citta) = "pertunmaa";