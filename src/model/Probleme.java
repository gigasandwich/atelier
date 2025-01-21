package model; 

public class Probleme {
    private int idProbleme;
    private String descriptionProbleme;
    private String categorieProbleme;

    public Probleme(int idProbleme, String descriptionProbleme, String categorieProbleme) {
        this.idProbleme = idProbleme;
        this.descriptionProbleme = descriptionProbleme;
        this.categorieProbleme = categorieProbleme;
    }

    /*
     * Getters
     */
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
