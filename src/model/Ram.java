package model;

public class Ram {
    @FieldInfo(label = "ID", type = "number", required = false)
    private int idRam;

    @FieldInfo(label = "Nombre de RAM", type = "number")
    private int nombreRam;

    public Ram(int idRam, int nombreRam) {
        this.idRam = idRam;
        this.nombreRam = nombreRam;
    }

    public int getIdRam() {
        return idRam;
    }

    public int getNombreRam() {
        return nombreRam;
    }
}
