package dao;

import java.sql.*;
import model.Ordinateur;

public class OrdinateurDao extends GenericDaoImpl<Ordinateur> {
    public OrdinateurDao() {
        super("ordinateur", "id_ordinateur");
    }

    @Override
    protected Ordinateur resultSetToEntity(ResultSet rs) throws SQLException {
        Ordinateur ordinateur = new Ordinateur(
                rs.getInt("idOrdinateur"),
                rs.getString("numeroSerie"),
                rs.getInt("idCarteGraphique"),
                rs.getInt("idClient"),
                rs.getInt("idRam"),
                rs.getInt("idProcesseur"),
                rs.getInt("idTypeOrdinateur"),
                rs.getInt("idModele"));

        return ordinateur;
    }

    @Override
    protected void entityToPreparedStatement(Ordinateur ordinateur, PreparedStatement ps) throws SQLException {
        // ps.setInt(1, ordinateur.getidOrdinateur());
        ps.setString(1, ordinateur.getNumeroSerie());
        ps.setInt(2, ordinateur.getIdCarteGraphique());
        ps.setInt(3, ordinateur.getIdClient());
        ps.setInt(4, ordinateur.getIdRam());
        ps.setInt(5, ordinateur.getIdProcesseur());
        ps.setInt(6, ordinateur.getIdTypeOrdinateur());
        ps.setInt(7, ordinateur.getIdModele());
        // ps.setFloat(7, ordinateur.getStockage());
    }

    @Override
    public String[] getInsertColumnsArray() {
        return new String[] { "numero_serie", "id_client", "id_ram", "id_processeur", "id_type_ordinateur",
                "id_modele" /* , "stockage" */ };
    }

    @Override
    protected int getIdFromEntity(Ordinateur ordinateur) {
        return ordinateur.getIdOrdinateur();
    }
}
