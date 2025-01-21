package model; 

public class Client {
    private int idClient;
    private String nomClient;
    private String prenomClient;
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
