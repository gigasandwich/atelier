package test;

import dao.*;
import model.*;
import java.util.List;

public class TestMarque {
    public static void main(String[] args) {
        MarqueDao marqueDao = new MarqueDao();

        // Insert example
        Marque newMarque = new Marque(0, "Dell");
        marqueDao.insert(newMarque);

        // Select all examples
        List<Marque> marques = marqueDao.selectAll();
        for (Marque marque : marques) {
            System.out.println(marque.getNomMarque());
        }

        // Select by ID example
        Marque selectedMarque = marqueDao.select(1);
        System.out.println("Selected marque: " + selectedMarque.getNomMarque());

        // Update example
        Marque updatedMarque = new Marque(1, "Updated Dell");
        marqueDao.update(selectedMarque, updatedMarque);

        // Delete example
        marqueDao.delete(1);
    }
}