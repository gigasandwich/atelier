package dao;

import model.Client;
import java.sql.*;

public class ClientDao extends GenericDaoImpl<Client> {
    public ClientDao() {
        super("client", "id_client");
    }

    @Override
    protected Client resultSetToEntity(ResultSet rs) throws SQLException {
        return new Client(rs.getInt("id_client"), rs.getString("nom_client"), rs.getString("prenom_client"), rs.getString("contact"));
    }

    @Override
    protected void entityToPreparedStatement(Client client, PreparedStatement ps) throws SQLException {
        // Tsy asina ID satria iny SERIAL no sady efa azo ao @ methode getIdFromEntity
        ps.setString(1, client.getNomClient());
        ps.setString(2, client.getPrenomClient());
        ps.setString(3, client.getContact());
    }

    @Override
    public String[] getInsertColumnsArray() {
        return new String[]{"nom_client", "prenom_client", "contact"};
    }

    // Ampiasaina ao @ update 
    @Override
    protected int getIdFromEntity(Client client) {
        return client.getIdClient();
    }
}