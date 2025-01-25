package model;

public class Technicien {
    @FieldInfo(label = "ID", type = "number", required = false)
    private int idTechnicien;

    @FieldInfo(label = "Nom du Technicien", type = "text")
    private String nomTechnicien;

    @FieldInfo(label = "Numéro d'Employé", type = "text")
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
