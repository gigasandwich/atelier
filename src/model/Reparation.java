package model; 

import java.util.Date;

import dao.ProblemeDao;
import dao.TechnicienDao;

public class Reparation {
    // Crud pour id seulement
    int idReparation;
    String descriptionSolution;
    Date dateDepot;
    Date dateRetour;
    float coutReparation;
    String statutReparation;
    int idTechnicien;
    int idProbleme;

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

    
    public Technicien getTechnicien(){
        TechnicienDao technicienDao = new TechnicienDao();
        return technicienDao.select(this.idTechnicien);
    }
    public Probleme getProbleme(){
        ProblemeDao problemeDao = new ProblemeDao();
        return problemeDao.select(this.idProbleme);
    }

    /*
     * Getters
     */
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
