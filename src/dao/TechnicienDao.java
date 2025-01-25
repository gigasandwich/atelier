package dao;

import model.Technicien;
import java.sql.*;

public class TechnicienDao extends GenericDaoImpl<Technicien> {
    public TechnicienDao() {
        super("technicien", "id_technicien");
    }

    @Override
    protected Technicien resultSetToEntity(ResultSet rs) throws SQLException {
        return new Technicien(rs.getInt("id_technicien"), rs.getString("nom_technicien"), rs.getString("numero_employe"));
    }

    @Override
    protected void entityToPreparedStatement(Technicien technicien, PreparedStatement ps) throws SQLException {
        ps.setString(1, technicien.getNomTechnicien());
        ps.setString(2, technicien.getNumeroEmploye());
    }

    @Override
    public String[] getInsertColumnsArray() {
        return new String[]{"nom_technicien", "numero_employe"};
    }

    @Override
    protected int getIdFromEntity(Technicien technicien) {
        return technicien.getIdTechnicien();
    }
}
