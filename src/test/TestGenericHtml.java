package test;
import dao.*;
import html.*;
import java.util.List;

public class TestGenericHtml {
    public static void main(String[] args) {
        String model = "probleme";
        Class<?> modelClass = DaoModelUtil.getModelClass(model);
        GenericDaoImpl<?> dao = DaoModelUtil.getDao(model);
        List<?> entities = dao.selectAll();
        
        String html = FormGenerator.generateForm(modelClass);
        // html = ListGenerator.generateTable(entities);

        System.out.println(html);
    }
}
