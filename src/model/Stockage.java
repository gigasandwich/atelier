package model;

public class Stockage {
    @FieldInfo(label = "ID", type = "number", required = false)
    private int idStockage;

    @FieldInfo(label = "Type de Stockage", type = "text")
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
