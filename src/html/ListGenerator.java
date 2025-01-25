package html;

import dao.DaoModelUtil;
import java.lang.reflect.Field;
import java.util.List;
import model.FieldInfo;

// Tsy tonga dia atao anaty methode le List fa any @ jsp ami'izay afaka anaovana filtre

public class ListGenerator {
    public static <T> String generateTable(List<T> entities) {

        StringBuilder tableHtml = new StringBuilder();
        tableHtml.append("<table class=\"table table-bordered\">\n")
                .append("<thead>\n<tr>\n");

        if (!entities.isEmpty()) {
            String modelName = entities.get(0).getClass().getSimpleName().toLowerCase();

            Field[] fields = entities.get(0).getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(FieldInfo.class)) {
                    FieldInfo fieldInfo = field.getAnnotation(FieldInfo.class);
                    tableHtml.append("<th>").append(fieldInfo.label()).append("</th>\n");
                }
            }
            tableHtml.append("<th>Actions</th>\n</tr>\n</thead>\n<tbody>\n");

            for (T entity : entities) {
                tableHtml.append("<tr>\n");
                for (Field field : fields) {
                    if (field.isAnnotationPresent(FieldInfo.class)) {
                        field.setAccessible(true); // Make private fields accessible
                        try {
                            Object value = field.get(entity); // Get the value of the field
                            tableHtml.append("<td>").append(value != null ? value.toString() : "N/A").append("</td>\n");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                int id = (int) DaoModelUtil.getEntityId(entity);
                tableHtml.append("<td>\n")
                        .append("<a href=\"/atelier/edit/").append(modelName).append("?id=").append(id).append("\">Modifier</a> |\n")
                        .append("<a href=\"/atelier/delete/").append(modelName).append("?id=")
                            .append(id)
                            .append("\" onclick=\"return confirm('Voulez vous supprimer?');\">Supprimer</a>\n")
                        .append("</td>\n</tr>\n");
            }
        }

        tableHtml.append("</tbody>\n</table>\n");
        return tableHtml.toString();
    }

    
}