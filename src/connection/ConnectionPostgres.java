package connection;
import java.sql.*;

public class ConnectionPostgres {
    static final String URL = "jdbc:postgresql://localhost:5432/atelier_reparation";
    static final String USER = "atelier";
    static final String PASSWORD = "atelier";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            System.out.println("Postgre Connexion: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Postgre Driver not found: " + e.getMessage());
        }
        return null;
    }
}