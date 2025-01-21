package dao;

import model.Marque;
import java.sql.*;

public class MarqueDao extends GenericDaoImpl<Marque> {
    public MarqueDao() {
        super("marque", "id_marque");
    }

    @Override
    protected Marque resultSetToEntity(ResultSet rs) throws SQLException {
        return new Marque(rs.getInt("id_marque"), rs.getString("nom_marque"));
    }

    @Override
    protected void entityToPreparedStatement(Marque marque, PreparedStatement ps) throws SQLException {
        ps.setString(1, marque.getNomMarque());
    }

    @Override
    protected String[] getInsertColumnsArray() {
        return new String[]{"nom_marque"};
    }

    @Override
    protected int getIdFromEntity(Marque marque) {
        return marque.getIdMarque();
    }
}
