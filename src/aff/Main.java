package aff;
import dao.*;
import html.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String model = "client";
        Class<?> modelClass = DaoModelUtil.getModelClass(model);
        GenericDaoImpl<?> dao = DaoModelUtil.getDao(model);
        List<?> entities = dao.selectAll();
        
        String html = FormGenerator.generateForm(modelClass);
        html = ListGenerator.generateTable(entities);

        System.out.println(html);
    }
}
