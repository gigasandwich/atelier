package html;

import generalized.FieldInfo;
import java.lang.reflect.Field;

public class FormGenerator {
    public static <T> String generateForm(Class<T> modelClass) {
        StringBuilder formHtml = new StringBuilder();
        formHtml.append("<form action=\"/generic?action=insert&model=").append(modelClass.getSimpleName().toLowerCase()).append("\" method=\"POST\">\n");

        Field[] fields = modelClass.getDeclaredFields(); // Get fields instead of methods

        for (Field field : fields) {
            if (field.isAnnotationPresent(FieldInfo.class)) {
                FieldInfo fieldInfo = field.getAnnotation(FieldInfo.class);
                String fieldName = field.getName(); // Use the field name directly

                // Check if the field is required
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
}