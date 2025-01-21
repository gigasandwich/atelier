package model;

public class Stockage {
    private int idStockage;
    private int quantiteStockage;
    private String typeStockage;

    public Stockage(int idStockage, int quantiteStockage, String typeStockage) {
        this.idStockage = idStockage;
        this.quantiteStockage = quantiteStockage;
        this.typeStockage = typeStockage;
    }

    /*
     * Getters
     */

    public int getIdStockage() {
        return idStockage;
    }

    public int getQuantiteStockage() {
        return quantiteStockage;
    }

    public String getTypeStockage() {
        return typeStockage;
    }
}
