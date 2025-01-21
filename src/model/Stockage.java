package model;

public class Stockage {
    private int idStockage;
    private String typeStockage;

    public Stockage(int idStockage, String typeStockage) {
        this.idStockage = idStockage;
        this.typeStockage = typeStockage;
    }

    public int getIdStockage() {
        return idStockage;
    }

    public String getTypeStockage() {
        return typeStockage;
    }
}
