package model; 

public class Client {
    @FieldInfo(label = "ID", type = "number", required = false)
    private int idClient;

    @FieldInfo(label = "Nom", type = "text")
    private String nomClient;

    @FieldInfo(label = "Prenom", type = "text")
    private String prenomClient;

    @FieldInfo(label = "Contact", type = "text")
    private String contact;

    public Client(int idClient, String nomClient, String prenomClient, String contact) {
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.contact = contact;
    }

    /*
     * Getters
     */
    public int getIdClient() {
        return idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public String getContact() {
        return contact;
    }
}
