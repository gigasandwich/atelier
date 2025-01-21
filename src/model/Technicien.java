package model; 

public class Technicien {
    int idTechnicien;
    String nomTechnicien;
    String numeroEmploye;

    public Technicien(int idTechnicien, String nomTechnicien, String numeroEmploye) {
        this.idTechnicien = idTechnicien;
        this.nomTechnicien = nomTechnicien;
        this.numeroEmploye = numeroEmploye;
    }

    /*
     * Getters
     */
    public int getIdTechnicien() {
        return idTechnicien;
    }

    public String getNomTechnicien() {
        return nomTechnicien;
    }

    public String getNumeroEmploye() {
        return numeroEmploye;
    }
}
