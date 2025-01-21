package model;

public class TypeOrdinateur {
    private int idTypeOrdinateur;
    private String nomTypeOrdinateur;

    public TypeOrdinateur(int idTypeOrdinateur, String nomTypeOrdinateur) {
        this.idTypeOrdinateur = idTypeOrdinateur;
        this.nomTypeOrdinateur = nomTypeOrdinateur;
    }

    public int getIdTypeOrdinateur() {
        return idTypeOrdinateur;
    }

    public String getNomTypeOrdinateur() {
        return nomTypeOrdinateur;
    }
}