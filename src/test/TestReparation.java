package test;

import dao.ReparationDao;
import model.Reparation;

import java.util.List;

public class TestReparation {
    public static void main(String[] args) {
        ReparationDao reparationDao = new ReparationDao();

        // Insert
        // Reparation newReparation = new Reparation(4, "Fixed issue", new java.util.Date(), new java.util.Date(), 150.00f, "Completed", 1, 2);
        // reparationDao.insert(newReparation);
        // System.out.println("Inserted new reparation: " + newReparation.getDescriptionSolution());

        // Select
        List<Reparation> reparations = reparationDao.selectAll();
        System.out.println("All reparations:");
        for (Reparation reparation : reparations) {
            System.out.println(reparation.getDescriptionSolution() + " - " + reparation.getStatutReparation());
        }

        // Select by id
        Reparation selectedReparation = reparationDao.select(3);
        if (selectedReparation != null) {
            System.out.println("Selected reparation: " + selectedReparation.getDescriptionSolution() + " - " + selectedReparation.getStatutReparation());
        } else {
            System.out.println("Reparation not found.");
        }

        // Update
        // Reparation updatedReparation = new Reparation(3, "Updated issue", new java.util.Date(), new java.util.Date(), 200.00f, "In Progress", 1, 2);
        // reparationDao.update(selectedReparation, updatedReparation);
        // System.out.println("Updated reparation: " + updatedReparation.getDescriptionSolution());

        // Delete
        // reparationDao.delete(3);
        // System.out.println("Deleted reparation with ID 3");
    }
}