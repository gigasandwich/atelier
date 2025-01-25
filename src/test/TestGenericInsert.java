package test;

import dao.*;
import html.*; 
import java.util.List;
import model.*;

public class TestGenericInsert {
    public static void main(String[] args) {
        String model = "probleme";
        Class<?> modelClass = DaoModelUtil.getModelClass(model);
        GenericDaoImpl<Probleme> dao = (GenericDaoImpl<Probleme>) DaoModelUtil.getDao(model);

        // Probleme newProbleme = new Probleme(0, "Test Description", "Test Category"); 
        // dao.insert(newProbleme.getDescriptionProbleme(), newProbleme.getCategorieProbleme());

        String description = "Test Description";
        String category = "Test Category";
        // dao.insert(description, category);

        List<Probleme> entities = dao.selectAll();

        String html = ListGenerator.generateTable(entities);

        System.out.println(html);
    }
}