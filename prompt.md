I have this class for example (there are a lot more), it has its getters and setters.
package model; 
import generalized.*;

```java
public class Client {
    @FieldInfo(label = "ID", type = "number", required = false)
    private int idClient;

    @FieldInfo(label = "Nom", type = "text")
    private String nomClient;

    @FieldInfo(label = "Prenom", type = "text")
    private String prenomClient;

    @FieldInfo(label = "Contact", type = "text")
    private String contact;

    public Client(int idClient, String nomClient, String prenomClient, String contact) {
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.contact = contact;
    }
...
}
```

Also has these:
```java
package dao;
import java.util.List;

public interface GenericDao<T> {
    List<T> selectAll();
    T select(int id);
    void insert(T entity);
    void update(T oldEntity, T newEntity);
    void delete(int id);
}

package dao;

import connection.ConnectionPostgres;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
    protected abstract T resultSetToEntity(ResultSet rs) throws SQLException;
    protected abstract void entityToPreparedStatement(T entity, PreparedStatement ps) throws SQLException;
    protected abstract String[] getInsertColumnsArray(); // eg: ["nom_client", "contact"]
    protected abstract int getIdFromEntity(T entity); // ampiasaina ao @ update (eg: client.getId())

    private final String TABLENAME;
    private final String IDCOLUMN; // Primary key

    public GenericDaoImpl(String tableName, String idColumn) {
        this.TABLENAME = tableName;
        this.IDCOLUMN = idColumn;
    }
    
    /*
     * SELECT
     */
    @Override
    public List<T> selectAll() {
        List<T> entities = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLENAME;
        try (Connection conn = ConnectionPostgres.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                entities.add(resultSetToEntity(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return entities;
    }

    @Override
    public T select(int id) {
        String sql = "SELECT * FROM " + TABLENAME + " WHERE " + IDCOLUMN + " = ?";
        try (Connection conn = ConnectionPostgres.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * INSERT
     */
    @Override
    public void insert(T entity) {
        String sql = "INSERT INTO " + TABLENAME + " (" + getInsertColumns() + ") VALUES (" + getInsertPlaceholders() + ")";
        try (Connection conn = ConnectionPostgres.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            entityToPreparedStatement(entity, ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected String getInsertColumns() {
        return String.join(", ", getInsertColumnsArray());
    }
    protected String getInsertPlaceholders() {
        int count = getInsertColumnsArray().length;
        return String.join(",", "?".repeat(count).split(""));
    }

    /*
     * UPDATE
     */
    @Override
    public void update(T oldEntity, T newEntity) {
        String[] columns = getInsertColumnsArray();
        String setClause = String.join(" = ?, ", columns) + " = ?";
        String sql = "UPDATE " + TABLENAME + " SET " + setClause + " WHERE " + IDCOLUMN + " = ?";
        try (Connection conn = ConnectionPostgres.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            entityToPreparedStatement(newEntity, ps);
            ps.setInt(columns.length + 1, getIdFromEntity(oldEntity));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * DELETE
     */
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM " + TABLENAME + " WHERE " + IDCOLUMN + " = ?";
        try (Connection conn = ConnectionPostgres.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

and this of course:
```java
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
    protected String[] getInsertColumnsArray() {
        return new String[]{"nom_client", "prenom_client", "contact"};
    }

    // Ampiasaina ao @ update 
    @Override
    protected int getIdFromEntity(Client client) {
        return client.getIdClient();
    }
}

I have this class that generates an html form:
package utils;

import generalized.FieldInfo;
import dao.GenericDaoImpl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FormGenerator {
    public static <T> String generateForm(Class<T> modelClass, GenericDaoImpl<T> dao) {
        StringBuilder formHtml = new StringBuilder();
        formHtml.append("<form action=\"/generic?action=insert&model=").append(modelClass.getSimpleName().toLowerCase()).append("\" method=\"POST\">\n");

        String[] insertColumns = dao.getRequiredInsertColumns();
        Method[] methods = modelClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(FieldInfo.class)) {
                FieldInfo fieldInfo = method.getAnnotation(FieldInfo.class);
                String fieldName = getFieldName(method);

                if (fieldInfo.required() || isFieldInInsertColumns(fieldName, insertColumns)) {
                    formHtml.append("<div class=\"form-group\">\n")
                            .append("<label for=\"").append(fieldName).append("\">").append(fieldInfo.label()).append(":</label>\n");

                    if ("select".equals(fieldInfo.type())) {
                        formHtml.append("<select id=\"").append(fieldName).append("\" name=\"").append(fieldName).append("\" class=\"form-control\"")
                                .append(fieldInfo.required() ? " required>" : ">");

                        for (String option : fieldInfo.options()) {
                            formHtml.append("<option value=\"").append(option).append("\">").append(option).append("</option>\n");
                        }
                        formHtml.append("</select>\n");
                    } else {
                        formHtml.append("<input type=\"").append(fieldInfo.type()).append("\" id=\"").append(fieldName).append("\" name=\"").append(fieldName).append("\" class=\"form-control\"")
                                .append(fieldInfo.required() ? " required" : "").append(">\n");
                    }

                    formHtml.append("</div>\n");
                }
            }
        }

        formHtml.append("<button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n");
        formHtml.append("</form>\n");
        return formHtml.toString();
    }

    private static boolean isFieldInInsertColumns(String fieldName, String[] insertColumns) {
        for (String column : insertColumns) {
            if (column.equalsIgnoreCase(fieldName)) {
                return true;
            }
        }
        return false;
    }

    // Getter
    private static String getFieldName(Method method) {
        String name = method.getName().replace("get", "");
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }
}
```
And this too for listing all of the models  
```java
package utils;

import generalized.FieldInfo;
import java.lang.reflect.Method;
import java.util.List;

public class ListGenerator {
    // Tsy tonga dia atao anaty methode le List fa any @ jsp ami'izay afaka anaovana filtre
    public static <T> String generateTable(List<T> entities) {
        StringBuilder tableHtml = new StringBuilder();
        tableHtml.append("<table class=\"table table-bordered\">\n")
                .append("<thead>\n<tr>\n");

        if (!entities.isEmpty()) {
            Method[] methods = entities.get(0).getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(FieldInfo.class)) {
                    FieldInfo fieldInfo = method.getAnnotation(FieldInfo.class);
                    tableHtml.append("<th>").append(fieldInfo.label()).append("</th>\n");
                }
            }
            tableHtml.append("<th>Actions</th>\n</tr>\n</thead>\n<tbody>\n");

            for (T entity : entities) {
                tableHtml.append("<tr>\n");
                for (Method method : methods) {
                    if (method.isAnnotationPresent(FieldInfo.class)) {
                        try {
                            tableHtml.append("<td>").append(method.invoke(entity)).append("</td>\n");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                tableHtml.append("<td>\n")
                        .append("<a href=\"edit.jsp?id=").append(getEntityId(entity)).append("\">Edit</a> |\n")
                        .append("<a href=\"delete.jsp?id=").append(getEntityId(entity)).append("\">Delete</a>\n")
                        .append("</td>\n</tr>\n");
            }
        }

        tableHtml.append("</tbody>\n</table>\n");
        return tableHtml.toString();
    }

    private static <T> Object getEntityId(T entity) {
        try {
            Method method = entity.getClass().getDeclaredMethod("getId");
            return method.invoke(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
```

You can change codes if it makes the application work.

- Make something like insert-@pattern or list-@pattern on the webservlet url and like if pattern = client, the T is Client.class and the dao is new ClientDao()

- I want two different servlets, one for insert and one for list

- For the `insert servlet`:
When I go to a link /insert-client for example, it calls the formGenerator method and shows the forms to insert a new client. Same with insert-ordinateur.

- For the `list servlet`:
And when I go to /list-client, it calls the listGenerator one and lists all of the ordinateurs.  When I go to /list-ordinateur, it lists all of the ordinateurs.

I don't wanna define a long xml thing or create different servlets for just showing a form or a list with the same pattern.