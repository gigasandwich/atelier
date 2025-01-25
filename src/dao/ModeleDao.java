package dao;

import model.Modele;
import java.sql.*;

public class ModeleDao extends GenericDaoImpl<Modele> {
    public ModeleDao() {
        super("modele", "id_modele");
    }

    @Override
    protected Modele resultSetToEntity(ResultSet rs) throws SQLException {
        return new Modele(
            rs.getInt("id_modele"),
            rs.getString("nom_modele"),
            rs.getInt("id_marque")
        );
    }

    @Override
    protected void entityToPreparedStatement(Modele modele, PreparedStatement ps) throws SQLException {
        ps.setString(1, modele.getNomModele());
        ps.setInt(2, modele.getIdMarque());
    }

    @Override
    public String[] getInsertColumnsArray() {
        return new String[]{"nom_modele", "id_marque"};
    }

    @Override
    protected int getIdFromEntity(Modele modele) {
        return modele.getIdModele();
    }
}
