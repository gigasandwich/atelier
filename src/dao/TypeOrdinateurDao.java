package dao;

import model.TypeOrdinateur;
import java.sql.*;

public class TypeOrdinateurDao extends GenericDaoImpl<TypeOrdinateur> {
    public TypeOrdinateurDao() {
        super("type_ordinateur", "id_type_ordinateur");
    }

    @Override
    protected TypeOrdinateur resultSetToEntity(ResultSet rs) throws SQLException {
        return new TypeOrdinateur(rs.getInt("id_type_ordinateur"), rs.getString("nom_type_ordinateur"));
    }

    @Override
    protected void entityToPreparedStatement(TypeOrdinateur typeOrdinateur, PreparedStatement ps) throws SQLException {
        ps.setString(1, typeOrdinateur.getNomTypeOrdinateur());
    }

    @Override
    public String[] getInsertColumnsArray() {
        return new String[]{"nom_type_ordinateur"};
    }

    @Override
    protected int getIdFromEntity(TypeOrdinateur typeOrdinateur) {
        return typeOrdinateur.getIdTypeOrdinateur();
    }
}
