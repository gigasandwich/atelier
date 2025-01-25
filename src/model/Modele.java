package model;

public class Modele {
    @FieldInfo(label = "ID", type = "number", required = false)
    private int idModele;

    @FieldInfo(label = "Nom du Modèle", type = "text")
    private String nomModele;

    @FieldInfo(label = "ID de la Marque", type = "number")
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