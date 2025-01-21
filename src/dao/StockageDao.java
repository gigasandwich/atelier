package dao;

import model.Stockage;
import connection.ConnectionPostgres;
import java.sql.*;

public class StockageDao {
    public Stockage getStockageByOrdinateurId(int idOrdinateur) {
        String query = "SELECT s.* FROM stockage s JOIN ordinateur_stockage os ON s.id_stockage = os.id_stockage WHERE os.id_ordinateur = ?";
        try (Connection connection = ConnectionPostgres.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idOrdinateur);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Stockage(rs.getInt("id_stockage"), rs.getString("type_stockage"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
