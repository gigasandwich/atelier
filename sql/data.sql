-- Insert into marque
INSERT INTO marque (nom_marque) VALUES 
('Dell'),
('HP'),
('Lenovo'),
('Apple'),
('Asus');

-- Insert into modele
INSERT INTO modele (nom_modele, id_marque) VALUES 
('Inspiron', 1),
('Pavilion', 2),
('ThinkPad', 3),
('MacBook', 4),
('ZenBook', 5);

-- Insert into type_ordinateur
INSERT INTO type_ordinateur (nom_type_ordinateur) VALUES 
('Laptop'),
('Desktop'),
('Server'),
('Gaming'),
('Workstation');

-- Insert into processeur
INSERT INTO processeur (nom_processeur) VALUES 
('Intel i5'),
('Intel i7'),
('AMD Ryzen 5'),
('AMD Ryzen 7'),
('Apple M1');

-- Insert into ram
INSERT INTO ram (nombre_ram) VALUES 
(4),
(8),
(16),
(32),
(64);

-- Insert into stockage
INSERT INTO stockage (type_stockage) VALUES 
('SSD'),
('HDD');

-- Insert into client
INSERT INTO client (nom_client, prenom_client, contact) VALUES 
('Doe', 'John', 'john.doe@example.com'),
('Smith', 'Jane', 'jane.smith@example.com'),
('Brown', 'Charlie', 'charlie.brown@example.com'),
('Johnson', 'Chris', 'chris.johnson@example.com'),
('Taylor', 'Pat', 'pat.taylor@example.com');

-- Insert into probleme
INSERT INTO probleme (description_probleme, categorie_probleme) VALUES 
('Screen not working', 'Hardware'),
('Battery issue', 'Hardware'),
('Slow performance', 'Software'),
('No sound', 'Hardware'),
('Overheating', 'Hardware');

-- Insert into technicien
INSERT INTO technicien (nom_technicien, numero_employe) VALUES 
('Tech1', 'EMP001'),
('Tech2', 'EMP002'),
('Tech3', 'EMP003'),
('Tech4', 'EMP004'),
('Tech5', 'EMP005');

-- Insert into carte_graphique
INSERT INTO carte_graphique (nom_carte_graphique) VALUES 
('NVIDIA GTX 1050'),
('NVIDIA RTX 3060'),
('AMD Radeon RX 580'),
('Integrated'),
('Apple GPU');

-- Insert into ordinateur
INSERT INTO ordinateur (numero_serie, id_carte_graphique, id_client, id_ram, id_processeur, id_type_ordinateur, id_modele) VALUES 
('SN12345', 1, 1, 2, 1, 1, 1),
('SN67890', 2, 2, 3, 2, 2, 2),
('SN11223', 3, 3, 4, 3, 3, 3),
('SN44556', 4, 4, 5, 4, 4, 4),
('SN78901', 5, 5, 1, 5, 5, 5);

-- Insert into reparation
INSERT INTO reparation (description_solution, date_depot, date_retour, cout_reparation, statut_reparation, id_technicien, id_probleme) VALUES 
('Replaced screen', '2025-01-01', '2025-01-05', 150.00, 'Completed', 1, 1),
('Replaced battery', '2025-01-02', '2025-01-06', 100.00, 'Completed', 2, 2),
('Optimized performance', '2025-01-03', '2025-01-07', 75.00, 'Completed', 3, 3),
('Fixed sound driver', '2025-01-04', '2025-01-08', 50.00, 'Completed', 4, 4),
('Cleaned internal components', '2025-01-05', '2025-01-09', 25.00, 'Completed', 5, 5);

-- Insert into ordinateur_stockage
INSERT INTO ordinateur_stockage (id_ordinateur, id_stockage, quantite_stockage) VALUES 
(1, 1, 256),
(2, 2, 512),
(3, 1, 128),
(4, 2, 1024),
(5, 1, 512);

-- Insert into ordinateur_probleme
INSERT INTO ordinateur_probleme (id_ordinateur, id_probleme) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);
