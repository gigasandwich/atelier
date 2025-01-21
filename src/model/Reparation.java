package model;

import java.sql.Date;

public class Reparation {
    private int idReparation;
    private String descriptionSolution;
    private Date dateDepot;
    private Date dateRetour;
    private float coutReparation;
    private String statutReparation;
    private int idTechnicien;
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
