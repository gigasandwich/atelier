package dao;

import model.CarteGraphique;
import java.sql.*;

public class CarteGraphiqueDao extends GenericDaoImpl<CarteGraphique> {
    public CarteGraphiqueDao() {
        super("carte_graphique", "id_carte_graphique");
    }

    @Override
    protected CarteGraphique resultSetToEntity(ResultSet rs) throws SQLException {
        return new CarteGraphique(rs.getInt("id_carte_graphique"), rs.getString("nom_carte_graphique"));
    }

    @Override
    protected void entityToPreparedStatement(CarteGraphique carteGraphique, PreparedStatement ps) throws SQLException {
        ps.setString(1, carteGraphique.getNomCarteGraphique());
    }

    @Override
    protected String[] getInsertColumnsArray() {
        return new String[]{"nom_carte_graphique"};
    }

    @Override
    protected int getIdFromEntity(CarteGraphique carteGraphique) {
        return carteGraphique.getIdCarteGraphique();
    }
}
