package html;

import java.lang.reflect.Field;
import model.FieldInfo;

public class FormGenerator {
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
}