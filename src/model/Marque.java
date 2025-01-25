package model;

// Model classes
public class Marque {
    @FieldInfo(label = "ID", type = "number", required = false)
    private int idMarque;

    @FieldInfo(label = "Nom de la Marque", type = "text")
    private String nomMarque;

    public Marque(int idMarque, String nomMarque) {
        this.idMarque = idMarque;
        this.nomMarque = nomMarque;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public String getNomMarque() {
        return nomMarque;
    }
}