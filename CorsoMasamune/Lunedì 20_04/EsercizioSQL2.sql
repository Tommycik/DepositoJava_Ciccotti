-- create database Negozio;
use negozio;
/*create table Vendite (

    id INT not null,

    prodotto VARCHAR(100),

    categoria VARCHAR(50),

    quantita INT,

    prezzo_unitario DECIMAL(6,2),

    data_vendita DATE
	
);
INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (1, 'Smartphone Alpha', 'Elettronica', 2, 599.99, '2024-01-10');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (2, 'Monitor 24 Pollici', 'Elettronica', 1, 149.50, '2024-01-12');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (3, 'Sedia da Ufficio', 'Casa', 5, 85.00, '2024-01-15');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (4, 'Lampada LED', 'Casa', 10, 12.99, '2024-01-18');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (5, 'Tapis Roulant', 'Sport', 1, 450.00, '2024-01-20');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (6, 'Set Manubri 10kg', 'Sport', 2, 45.00, '2024-01-22');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (7, 'Notebook Pro 15', 'Elettronica', 1, 1200.00, '2024-01-25');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (8, 'Mouse Wireless', 'Elettronica', 15, 25.00, '2024-02-01');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (9, 'Tastiera Meccanica', 'Elettronica', 4, 75.00, '2024-02-05');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (10, 'Caffettiera Espresso', 'Casa', 3, 39.90, '2024-02-08');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (11, 'Set Penne Colorate', 'Cancelleria', 20, 5.50, '2024-02-10');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (12, 'Zaino Porta PC', 'Cancelleria', 8, 45.00, '2024-02-14');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (13, 'Cuffie Bluetooth', 'Elettronica', 6, 89.99, '2024-02-18');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (14, 'Tappetino Yoga', 'Sport', 12, 19.99, '2024-02-20');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (15, 'Frullatore a immersione', 'Casa', 2, 34.50, '2024-02-25');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (16, 'Smartwatch Fit', 'Elettronica', 7, 129.00, '2024-03-02');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (17, 'Borraccia Termica', 'Sport', 10, 15.00, '2024-03-05');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (18, 'Scrivania in Legno', 'Casa', 1, 199.00, '2024-03-10');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (19, 'Hard Disk Esterno 2TB', 'Elettronica', 3, 79.00, '2024-03-12');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) 
VALUES (20, 'Agenda 2024', 'Cancelleria', 25, 10.00, '2024-03-15');
*/
select categoria, count(id)  as venditeCategoria
from vendite
group by categoria;

select categoria, avg(prezzo_unitario) as mediaCategorie
from vendite
group by categoria;

select prodotto, sum(quantita) as totaleVenduti
from vendite
group by prodotto;

select max(prezzo_unitario) as max, min(prezzo_unitario) as min
from vendite;

select count(*) as venditeTotali
from vendite;

select prodotto, prezzo_unitario
from vendite
order by prezzo_unitario desc
limit 5;

select prodotto, sum(quantita) as prodottiVenduti
from vendite
group by prodotto
order by  prodottiVenduti asc
limit 3;