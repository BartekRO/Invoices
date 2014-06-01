INSERT INTO "Invoices".taxrate(id, description, rate) VALUES (1, '5%',0.05);
INSERT INTO "Invoices".taxrate(id, description, rate) VALUES (2, '7%',0.07);
INSERT INTO "Invoices".taxrate(id, description, rate) VALUES (3, '23%',0.23);


INSERT INTO "Invoices".contractor(id, addresscityzip, addressstreet, name) VALUES (1, 'addresscityzip1', 'addressstreet1', 'Intel');
INSERT INTO "Invoices".contractor(id, addresscityzip, addressstreet, name) VALUES (2, 'addresscityzip2', 'addressstreet2', 'IBM');
INSERT INTO "Invoices".contractor(id, addresscityzip, addressstreet, name) VALUES (3, 'addresscityzip3', 'addressstreet3', 'Microsoft');
INSERT INTO "Invoices".contractor(id, addresscityzip, addressstreet, name) VALUES (4, 'addresscityzip4', 'addressstreet4', 'HP');
INSERT INTO "Invoices".contractor(id, addresscityzip, addressstreet, name) VALUES (5, 'addresscityzip5', 'addressstreet5', 'Dell');
INSERT INTO "Invoices".contractor(id, addresscityzip, addressstreet, name) VALUES (6, 'addresscityzip6', 'addressstreet6', 'Onet');

INSERT INTO "Invoices".invoice( id, dateofissue, maturity, "number", subtotalamount, totalamount, id_contractor)
    VALUES (1,  '1994-11-29', '1994-11-29', 'FV-2001-1', 1099.98, 1256.98,  5);

INSERT INTO "Invoices".invoiceposition( id, description, quantity, total, unitprice, id_invoice, id_taxrate)
VALUES (1, 'Some random position 1', 2, 599.98, 249.99, 1, 2);

INSERT INTO "Invoices".invoiceposition( id, description, quantity, total, unitprice, id_invoice, id_taxrate)
VALUES (2, 'Some random position 2', 5, 500, 100, 1, 3);

INSERT INTO "Invoices".invoicetaxtotal(id, tax, taxsubtotal, id_invoice, id_taxrate) VALUES (1, 42, 599.98, 1, 2);
INSERT INTO "Invoices".invoicetaxtotal(id, tax, taxsubtotal, id_invoice, id_taxrate) VALUES (2, 115, 500, 1, 3);



