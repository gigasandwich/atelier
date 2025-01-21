package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Marque {
    private int idMarque;
    private String nomMarque;

    // Getters et Setters
    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    // Constructeurs
    public Marque() {

    }

    public Marque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    // Méthode pour récupérer toutes les marques (statique)
    public static List<Marque> getAll(Connection connection) throws SQLException {
        List<Marque> marques = new ArrayList<>();
        String query = "SELECT * FROM marque";
        try (PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Marque marque = new Marque();
                marque.setIdMarque(rs.getInt("id_marque"));
                marque.setNomMarque(rs.getString("nom_marque"));
                marques.add(marque);
            }
        }
        return marques;
    }
    

    // Méthode pour insérer une marque
    public void insert(Connection connection) throws SQLException {
        String query = "INSERT INTO marque (nom_marque) VALUES (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, this.nomMarque);
            ps.executeUpdate();
        }
    }
}
