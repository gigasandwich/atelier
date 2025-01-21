package model;

public class Technicien {
    private int idTechnicien;
    private String nomTechnicien;
    private String numeroEmploye;

    public Technicien(int idTechnicien, String nomTechnicien, String numeroEmploye) {
        this.idTechnicien = idTechnicien;
        this.nomTechnicien = nomTechnicien;
        this.numeroEmploye = numeroEmploye;
    }

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
