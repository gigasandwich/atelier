package model;

public class CarteGraphique {
    private int idCarteGraphique;
    private String nomCarteGraphique;

    public CarteGraphique(int idCarteGraphique, String nomCarteGraphique) {
        this.idCarteGraphique = idCarteGraphique;
        this.nomCarteGraphique = nomCarteGraphique;
    }

    public int getIdCarteGraphique() {
        return idCarteGraphique;
    }

    public String getNomCarteGraphique() {
        return nomCarteGraphique;
    }
}
