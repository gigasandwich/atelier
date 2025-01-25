package html;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import model.FieldInfo;

// Tsy tonga dia atao anaty methode le List fa any @ jsp ami'izay afaka anaovana filtre

public class ListGenerator {
    public static <T> String generateTable(List<T> entities) {
        StringBuilder tableHtml = new StringBuilder();
        tableHtml.append("<table class=\"table table-bordered\">\n")
                .append("<thead>\n<tr>\n");

        if (!entities.isEmpty()) {
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
            String entityName = entity.getClass().getSimpleName();
            String idMethodName = "getId" + entityName; 

            Method method = entity.getClass().getDeclaredMethod(idMethodName);
            return method.invoke(entity);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}