package model;

public class Ordinateur {
    @FieldInfo(label = "ID", type = "number", required = false)
    private int idOrdinateur;

    @FieldInfo(label = "Numéro de Série", type = "text")
    private String numeroSerie;

    @FieldInfo(label = "ID de la Carte Graphique", type = "number", required = false)
    private int idCarteGraphique;

    @FieldInfo(label = "ID du Client", type = "number")
    private int idClient;

    @FieldInfo(label = "ID de la RAM", type = "number")
    private int idRam;

    @FieldInfo(label = "ID du Processeur", type = "number")
    private int idProcesseur;

    @FieldInfo(label = "ID du Type d'Ordinateur", type = "number")
    private int idTypeOrdinateur;

    @FieldInfo(label = "ID du Modèle", type = "number")
    private int idModele;

    public Ordinateur(int idOrdinateur, String numeroSerie, int idCarteGraphique, int idClient, int idRam, int idProcesseur, int idTypeOrdinateur, int idModele) {
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
