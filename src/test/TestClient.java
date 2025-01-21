package test;

import dao.ClientDao;
import model.Client;

import java.util.List;

public class TestClient {
    public static void main(String[] args) {
        /*
         * ALEFA TSIRAIDRAY
         */
        ClientDao clientDao = new ClientDao();

        // Insert
        // Client newClient = new Client(4, "Herilaza", "Ony", "ony.herilaza@example.com");
        // clientDao.insert(newClient);
        // System.out.println("Inserted new client: " + newClient.getNomClient());

        // Select
        List<Client> clients = clientDao.selectAll();
        System.out.println("All clients:");
        for (Client client : clients) {
            System.out.println(client.getNomClient() + " - " + client.getContact());
        }

        // Select by id
        Client selectedClient = clientDao.select(3);
        if (selectedClient != null) {
            System.out.println("Selected client: " + selectedClient.getNomClient() + " - " + selectedClient.getContact());
        } else {
            System.out.println("Client not found.");
        }

        // Update
        // Client updatedClient = new Client(3, "John", "Smith", "john.smith@example.com");
        // clientDao.update(selectedClient, updatedClient);
        // System.out.println("Updated client: " + updatedClient.getNomClient());

        // Delete
        // clientDao.delete(3);
        // System.out.println("Deleted client with ID 3");
    }
}
