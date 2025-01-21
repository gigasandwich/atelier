package model;

public class Processeur {
    private int idProcesseur;
    private String nomProcesseur;

    public Processeur(int idProcesseur, String nomProcesseur) {
        this.idProcesseur = idProcesseur;
        this.nomProcesseur = nomProcesseur;
    }

    public int getIdProcesseur() {
        return idProcesseur;
    }

    public String getNomProcesseur() {
        return nomProcesseur;
    }
}
