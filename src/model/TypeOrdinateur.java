package model;

public class TypeOrdinateur {
    @FieldInfo(label = "ID", type = "number", required = false)
    private int idTypeOrdinateur;
    @FieldInfo(label = "Nom du type de l'ordi", type = "text")
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