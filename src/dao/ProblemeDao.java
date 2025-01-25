package dao;

import model.Probleme;
import java.sql.*;

public class ProblemeDao extends GenericDaoImpl<Probleme> {
    public ProblemeDao() {
        super("probleme", "id_probleme");
    }

    @Override
    protected Probleme resultSetToEntity(ResultSet rs) throws SQLException {
        return new Probleme(rs.getInt("id_probleme"), rs.getString("description_probleme"), rs.getString("categorie_probleme"));
    }

    @Override
    protected void entityToPreparedStatement(Probleme probleme, PreparedStatement ps) throws SQLException {
        ps.setString(1, probleme.getDescriptionProbleme());
        ps.setString(2, probleme.getCategorieProbleme());
    }

    @Override
    public String[] getInsertColumnsArray() {
        return new String[]{"description_probleme", "categorie_probleme"};
    }

    @Override
    protected int getIdFromEntity(Probleme probleme) {
        return probleme.getIdProbleme();
    }
}
