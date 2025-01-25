package html;

import dao.DaoModelUtil;
import java.lang.reflect.Field;
import model.FieldInfo;

public class FormGenerator {

    // Ho an'ny insert
    public static <T> String generateForm(Class<T> modelClass) {
        StringBuilder formHtml = new StringBuilder();
        formHtml.append("<form action=\"/atelier/insertion/").append(modelClass.getSimpleName().toLowerCase()).append("\" method=\"POST\">\n");

        Field[] fields = modelClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FieldInfo.class)) {
                FieldInfo fieldInfo = field.getAnnotation(FieldInfo.class);
                String fieldName = field.getName();

                // Ny required ihany no apetraka eo @ form
                if (fieldInfo.required()) {
                    formHtml.append("<div class=\"form-group\">\n")
                            .append("<label for=\"").append(fieldName).append("\">").append(fieldInfo.label()).append(":</label>\n");

                    if ("select".equals(fieldInfo.type())) {
                        formHtml.append("<select id=\"").append(fieldName).append("\" name=\"").append(fieldName).append("\" class=\"form-control\" required>\n");
                        for (String option : fieldInfo.options()) {
                            formHtml.append("<option value=\"").append(option).append("\">").append(option).append("</option>\n");
                        }
                        formHtml.append("</select>\n");
                    } else {
                        formHtml.append("<input type=\"").append(fieldInfo.type()).append("\" id=\"").append(fieldName).append("\" name=\"").append(fieldName).append("\" class=\"form-control\" required>\n");
                    }

                    formHtml.append("</div>\n");
                }
            }
        }

        formHtml.append("<button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n");
        formHtml.append("</form>\n");
        return formHtml.toString();
    }

    // Ho an'ny update
    public static <T> String generateForm(Class<T> modelClass, T entity) {
        int id = (int) DaoModelUtil.getEntityId(entity);
        StringBuilder formHtml = new StringBuilder();
        formHtml.append("<form action=\"/atelier/edit/").append(modelClass.getSimpleName().toLowerCase()).append("?id=").append(id)
        .append("\" method=\"POST\">\n");

        Field[] fields = modelClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FieldInfo.class)) {
                FieldInfo fieldInfo = field.getAnnotation(FieldInfo.class);
                String fieldName = field.getName();

                if (fieldInfo.required()) {
                    formHtml.append("<div class=\"form-group\">\n")
                            .append("<label for=\"").append(fieldName).append("\">").append(fieldInfo.label()).append(":</label>\n");

                    // Get the current value of the field from the entity
                    String fieldValue = "";
                    try {
                        field.setAccessible(true);
                        Object value = field.get(entity);
                        fieldValue = value != null ? value.toString() : ""; // Convert to string, handle null
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    if ("select".equals(fieldInfo.type())) {
                        formHtml.append("<select id=\"").append(fieldName).append("\" name=\"").append(fieldName).append("\" class=\"form-control\" required>\n");
                        for (String option : fieldInfo.options()) {
                            // Set the selected attribute if the option matches the current value
                            String selected = option.equals(fieldValue) ? " selected" : "";
                            formHtml.append("<option value=\"").append(option).append("\"").append(selected).append(">").append(option).append("</option>\n");
                        }
                        formHtml.append("</select>\n");
                    } else {
                        formHtml.append("<input type=\"").append(fieldInfo.type()).append("\" id=\"").append(fieldName).append("\" name=\"").append(fieldName).append("\" class=\"form-control\" value=\"").append(fieldValue).append("\" required>\n");
                    }

                    formHtml.append("</div>\n");
                }
            }
        }

        formHtml.append("<input type=\"hidden\" name=\"id\" value=\"").append(id).append("\"/>\n");
        formHtml.append("<button type=\"submit\" class=\"btn btn-primary\">Update</button>\n");
        formHtml.append("</form>\n");
        return formHtml.toString();
    }
}