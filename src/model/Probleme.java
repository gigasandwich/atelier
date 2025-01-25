package model;

public class Probleme {
    @FieldInfo(label = "ID", type = "number", required = false)
    private int idProbleme;

    @FieldInfo(label = "Description du Problème", type = "text")
    private String descriptionProbleme;

    @FieldInfo(label = "Catégorie du Problème", type = "text")
    private String categorieProbleme;

    public Probleme(int idProbleme, String descriptionProbleme, String categorieProbleme) {
        this.idProbleme = idProbleme;
        this.descriptionProbleme = descriptionProbleme;
        this.categorieProbleme = categorieProbleme;
    }

    public int getIdProbleme() {
        return idProbleme;
    }

    public String getDescriptionProbleme() {
        return descriptionProbleme;
    }

    public String getCategorieProbleme() {
        return categorieProbleme;
    }
}
