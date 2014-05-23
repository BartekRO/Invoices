INSERT INTO "Invoices".tuser( id, username, password)
    VALUES (1, 'administrator', '$2a$10$8yVgSzeddfkaSzQlKSn8L.RHwLoe1tVDI34MAKTzrYWH.LnTZdi06');
    
INSERT INTO "Invoices".tuser( id, username, password)
    VALUES (2, 'someuser', '$2a$10$8yVgSzeddfkaSzQlKSn8L.RHwLoe1tVDI34MAKTzrYWH.LnTZdi06');
    
INSERT INTO "Invoices".user_roles(user_id, roles) VALUES (1, 'ROLE_USER');
INSERT INTO "Invoices".user_roles(user_id, roles) VALUES (2, 'ROLE_ADMIN');
INSERT INTO "Invoices".user_roles(user_id, roles) VALUES (1, 'ROLE_USER');
