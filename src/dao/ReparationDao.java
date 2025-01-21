package dao;

import model.Reparation;
import java.sql.*;

public class ReparationDao extends GenericDaoImpl<Reparation> {
    public ReparationDao() {
        super("reparation", "id_reparation");
    }

    @Override
    protected Reparation resultSetToEntity(ResultSet rs) throws SQLException {
        return new Reparation(rs.getInt("id_reparation"), rs.getString("description_solution"), rs.getDate("date_depot"), rs.getDate("date_retour"), rs.getFloat("cout_reparation"), rs.getString("statut_reparation"), rs.getInt("id_technicien"), rs.getInt("id_probleme"));
    }

    @Override
    protected void entityToPreparedStatement(Reparation reparation, PreparedStatement ps) throws SQLException {
        ps.setString(1, reparation.getDescriptionSolution());
        ps.setDate(2, new java.sql.Date(reparation.getDateDepot().getTime()));
        ps.setDate(3, new java.sql.Date(reparation.getDateRetour().getTime()));
        ps.setFloat(4, reparation.getCoutReparation());
        ps.setString(5, reparation.getStatutReparation());
        ps.setInt(6, reparation.getIdTechnicien());
        ps.setInt(7, reparation.getIdProbleme());
    }

    @Override
    protected String[] getInsertColumnsArray() {
        return new String[]{"description_solution", "date_depot", "date_retour", "cout_reparation", "statut_reparation", "id_technicien", "id_probleme"};
    }

    @Override
    protected int getIdFromEntity(Reparation reparation) {
        return reparation.getIdReparation();
    }
}
