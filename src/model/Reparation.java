package model;

import java.sql.Date;

public class Reparation {
    @FieldInfo(label = "ID", type = "number", required = false)
    private int idReparation;

    @FieldInfo(label = "Description de la Solution", type = "text")
    private String descriptionSolution;

    @FieldInfo(label = "Date de Dépôt", type = "date")
    private Date dateDepot;

    @FieldInfo(label = "Date de Retour", type = "date")
    private Date dateRetour;

    @FieldInfo(label = "Coût de Réparation", type = "number")
    private float coutReparation;

    @FieldInfo(label = "Statut de Réparation", type = "text")
    private String statutReparation;

    @FieldInfo(label = "ID du Technicien", type = "number")
    private int idTechnicien;

    @FieldInfo(label = "ID du Problème", type = "number")
    private int idProbleme;

    public Reparation(int idReparation, String descriptionSolution, Date dateDepot, Date dateRetour, float coutReparation, String statutReparation, int idTechnicien, int idProbleme) {
        this.idReparation = idReparation;
        this.descriptionSolution = descriptionSolution;
        this.dateDepot = dateDepot;
        this.dateRetour = dateRetour;
        this.coutReparation = coutReparation;
        this.statutReparation = statutReparation;
        this.idTechnicien = idTechnicien;
        this.idProbleme = idProbleme;
    }

    public int getIdReparation() {
        return idReparation;
    }

    public String getDescriptionSolution() {
        return descriptionSolution;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public float getCoutReparation() {
        return coutReparation;
    }

    public String getStatutReparation() {
        return statutReparation;
    }

    public int getIdTechnicien() {
        return idTechnicien;
    }

    public int getIdProbleme() {
        return idProbleme;
    }
}
