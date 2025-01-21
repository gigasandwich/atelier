DROP DATABASE IF EXISTS atelier;

CREATE USER reparation WITH PASSWORD 'reparation' CREATEDB;
CREATE DATABASE atelier_reparation OWNER reparation;
GRANT ALL PRIVILEGES ON DATABASE atelier_reparation TO reparation;
\c atelier_reparation;

DROP TABLE IF EXISTS marque;
DROP TABLE IF EXISTS modele;
DROP TABLE IF EXISTS type_ordinateur;
DROP TABLE IF EXISTS processeur;
DROP TABLE IF EXISTS ram;
DROP TABLE IF EXISTS stockage;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS probleme;
DROP TABLE IF EXISTS technicien;
DROP TABLE IF EXISTS carte_graphique;
DROP TABLE IF EXISTS ordinateur;
DROP TABLE IF EXISTS reparation;
DROP TABLE IF EXISTS ordinateur_stockage;
DROP TABLE IF EXISTS ordinateur_probleme;

CREATE TABLE marque(
   id_marque SERIAL,
   nom_marque VARCHAR(10)  NOT NULL,
   PRIMARY KEY(id_marque)
);

CREATE TABLE modele(
   id_modele SERIAL,
   nom_modele VARCHAR(50)  NOT NULL,
   id_marque INTEGER NOT NULL,
   PRIMARY KEY(id_modele),
   FOREIGN KEY(id_marque) REFERENCES marque(id_marque)
);

CREATE TABLE type_ordinateur(
   id_type_ordinateur SERIAL,
   nom_type_ordinateur VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_type_ordinateur)
);

CREATE TABLE processeur(
   id_processeur SERIAL,
   nom_processeur VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_processeur)
);

CREATE TABLE ram(
   id_ram SERIAL,
   nombre_ram INTEGER NOT NULL,
   PRIMARY KEY(id_ram)
);

CREATE TABLE stockage(
   id_stockage SERIAL,
   type_stockage VARCHAR(3)  NOT NULL,
   PRIMARY KEY(id_stockage)
);

CREATE TABLE client(
   id_client SERIAL,
   nom_client VARCHAR(50)  NOT NULL,
   prenom_client VARCHAR(50)  NOT NULL,
   contact VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_client)
);

CREATE TABLE probleme(
   id_probleme SERIAL,
   description_probleme VARCHAR(50)  NOT NULL,
   categorie_probleme VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_probleme)
);

CREATE TABLE technicien(
   id_technicien SERIAL,
   nom_technicien VARCHAR(50)  NOT NULL,
   numero_employe VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_technicien),
   UNIQUE(numero_employe)
);

CREATE TABLE carte_graphique(
   id_carte_graphique SERIAL,
   nom_carte_graphique VARCHAR(50) ,
   PRIMARY KEY(id_carte_graphique)
);

CREATE TABLE ordinateur(
   id_ordinateur SERIAL,
   numero_serie VARCHAR(50)  NOT NULL,
   id_carte_graphique INTEGER,
   id_client INTEGER NOT NULL,
   id_ram INTEGER NOT NULL,
   id_processeur INTEGER NOT NULL,
   id_type_ordinateur INTEGER NOT NULL,
   id_modele INTEGER NOT NULL,
   PRIMARY KEY(id_ordinateur),
   UNIQUE(numero_serie),
   FOREIGN KEY(id_carte_graphique) REFERENCES carte_graphique(id_carte_graphique),
   FOREIGN KEY(id_client) REFERENCES client(id_client),
   FOREIGN KEY(id_ram) REFERENCES ram(id_ram),
   FOREIGN KEY(id_processeur) REFERENCES processeur(id_processeur),
   FOREIGN KEY(id_type_ordinateur) REFERENCES type_ordinateur(id_type_ordinateur),
   FOREIGN KEY(id_modele) REFERENCES modele(id_modele)
);

CREATE TABLE reparation(
   id_reparation SERIAL,
   description_solution VARCHAR(50)  NOT NULL,
   date_depot DATE NOT NULL,
   date_retour DATE NOT NULL,
   cout_reparation NUMERIC(15,2)   NOT NULL,
   statut_reparation VARCHAR(50) ,
   id_technicien INTEGER NOT NULL,
   id_probleme INTEGER NOT NULL,
   PRIMARY KEY(id_reparation),
   FOREIGN KEY(id_technicien) REFERENCES technicien(id_technicien),
   FOREIGN KEY(id_probleme) REFERENCES probleme(id_probleme)
);

CREATE TABLE ordinateur_stockage(
   id_ordinateur INTEGER,
   id_stockage INTEGER,
   quantite_stockage INTEGER NOT NULL,
   PRIMARY KEY(id_ordinateur, id_stockage),
   FOREIGN KEY(id_ordinateur) REFERENCES ordinateur(id_ordinateur),
   FOREIGN KEY(id_stockage) REFERENCES stockage(id_stockage)
);

CREATE TABLE ordinateur_probleme(
   id_ordinateur INTEGER,
   id_probleme INTEGER,
   PRIMARY KEY(id_ordinateur, id_probleme),
   FOREIGN KEY(id_ordinateur) REFERENCES ordinateur(id_ordinateur),
   FOREIGN KEY(id_probleme) REFERENCES probleme(id_probleme)
);
