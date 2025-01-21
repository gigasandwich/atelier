package dao;

import model.Ordinateur;
import model.Stockage;
import connection.*;
import java.sql.*;

public class OrdinateurDao extends GenericDaoImpl<Ordinateur> {
    public OrdinateurDao() {
        super("ordinateur", "id_ordinateur");
    }

    @Override
    protected Ordinateur resultSetToEntity(ResultSet rs) throws SQLException {
        Ordinateur ordinateur = new Ordinateur(rs.getInt("id_ordinateur"), rs.getString("numero_serie"), rs.getInt("id_client"), rs.getInt("id_ram"), rs.getInt("id_processeur"), rs.getInt("id_type_ordinateur"), rs.getInt("id_modele"));
        return ordinateur;
    }

    private Stockage getStockageForOrdinateur(int idOrdinateur) throws SQLException {
        String query = "SELECT s.* FROM stockage s JOIN ordinateur_stockage os ON s.id_stockage = os.id_stockage WHERE os.id_ordinateur = ?";
        try (Connection connection = ConnectionPostgres.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idOrdinateur);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Stockage(rs.getInt("id_stockage"), rs.getInt("quantite_stockage"), rs.getString("type_stockage"));
                }
            }
        }
        return null;
    }

    @Override
    protected void entityToPreparedStatement(Ordinateur ordinateur, PreparedStatement ps) throws SQLException {
        ps.setString(1, ordinateur.getNumeroSerie());
        ps.setInt(2, ordinateur.getIdClient());
        ps.setInt(3, ordinateur.getIdRam());
        ps.setInt(4, ordinateur.getIdProcesseur());
        ps.setInt(5, ordinateur.getIdTypeOrdinateur());
        ps.setInt(6, ordinateur.getIdModele());
        // ps.setFloat(7, ordinateur.getStockage());
    }

    @Override
    protected String[] getInsertColumnsArray() {
        return new String[]{"numero_serie", "id_client", "id_ram", "id_processeur", "id_type_ordinateur", "id_modele" /*, "stockage" */};
    }

    @Override
    protected int getIdFromEntity(Ordinateur ordinateur) {
        return ordinateur.getIdOrdinateur();
    }
}
