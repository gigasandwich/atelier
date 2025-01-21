package model;

public class Modele {
    private int idModele;
    private String nomModele;
    private int idMarque;

    public Modele(int idModele, String nomModele, int idMarque) {
        this.idModele = idModele;
        this.nomModele = nomModele;
        this.idMarque = idMarque;
    }

    public int getIdModele() {
        return idModele;
    }

    public String getNomModele() {
        return nomModele;
    }

    public int getIdMarque() {
        return idMarque;
    }
}