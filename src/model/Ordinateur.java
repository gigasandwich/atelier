package model; 

import dao.StockageDao;
import dao.ClientDao;

public class Ordinateur {
    private int idOrdinateur;
    private String numeroSerie;
    private int idClient;
    private int idRam;
    private int idProcesseur;
    private int idTypeOrdinateur;
    private int idModele;
    // private float stockage;

    public Ordinateur(int idOrdinateur, String numeroSerie, int idClient, int idRam, int idProcesseur, int idTypeOrdinateur, int idModele /*, float stockage*/) {
        this.idOrdinateur = idOrdinateur;
        this.numeroSerie = numeroSerie;
        this.idClient = idClient;
        this.idRam = idRam;
        this.idProcesseur = idProcesseur;
        this.idTypeOrdinateur = idTypeOrdinateur;
        this.idModele = idModele;
        // this.stockage = stockage;
    }

    // Tsy natao attribut satria natao colonne
    public Stockage getStockage() {
        StockageDao stockageDao = new StockageDao();
        return stockageDao.getStockageByOrdinateurId(this.idOrdinateur);
    }

    public Client getClient() {
        ClientDao clientDao = new ClientDao();
        return clientDao.select(this.idClient);
    }

    /*
     * Getters 
     */
    public int getIdOrdinateur() {
        return idOrdinateur;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdRam() {
        return idRam;
    }

    public int getIdProcesseur() {
        return idProcesseur;
    }

    public int getIdTypeOrdinateur() {
        return idTypeOrdinateur;
    }

    public int getIdModele() {
        return idModele;
    }
}
