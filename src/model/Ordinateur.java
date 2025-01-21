package model;

public class Ordinateur {
    private int idOrdinateur;
    private String numeroSerie;
    private Integer idCarteGraphique;
    private int idClient;
    private int idRam;
    private int idProcesseur;
    private int idTypeOrdinateur;
    private int idModele;

    public Ordinateur(int idOrdinateur, String numeroSerie, Integer idCarteGraphique, int idClient, int idRam, int idProcesseur, int idTypeOrdinateur, int idModele) {
        this.idOrdinateur = idOrdinateur;
        this.numeroSerie = numeroSerie;
        this.idCarteGraphique = idCarteGraphique;
        this.idClient = idClient;
        this.idRam = idRam;
        this.idProcesseur = idProcesseur;
        this.idTypeOrdinateur = idTypeOrdinateur;
        this.idModele = idModele;
    }

    public int getIdOrdinateur() {
        return idOrdinateur;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public Integer getIdCarteGraphique() {
        return idCarteGraphique;
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
