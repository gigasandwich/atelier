package model;

public class Processeur {
    @FieldInfo(label = "ID", type = "number", required = false)
    private int idProcesseur;

    @FieldInfo(label = "Nom du Processeur", type = "text")
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
