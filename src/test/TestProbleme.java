package test;

import dao.ProblemeDao;
import model.Probleme;

import java.util.List;

public class TestProbleme {
    public static void main(String[] args) {
        ProblemeDao problemeDao = new ProblemeDao();

        // Insert
        // Probleme newProbleme = new Probleme(4, "Network issue", "Network");
        // problemeDao.insert(newProbleme);
        // System.out.println("Inserted new probleme: " + newProbleme.getDescriptionProbleme());

        // Select
        List<Probleme> problemes = problemeDao.selectAll();
        System.out.println("All problemes:");
        for (Probleme probleme : problemes) {
            System.out.println(probleme.getDescriptionProbleme() + " - " + probleme.getCategorieProbleme());
        }

        // Select by id
        Probleme selectedProbleme = problemeDao.select(3);
        if (selectedProbleme != null) {
            System.out.println("Selected probleme: " + selectedProbleme.getDescriptionProbleme() + " - " + selectedProbleme.getCategorieProbleme());
        } else {
            System.out.println("Probleme not found.");
        }

        // Update
        // Probleme updatedProbleme = new Probleme(3, "Updated issue", "Software");
        // problemeDao.update(selectedProbleme, updatedProbleme);
        // System.out.println("Updated probleme: " + updatedProbleme.getDescriptionProbleme());

        // Delete
        // problemeDao.delete(3);
        // System.out.println("Deleted probleme with ID 3");
    }
}
