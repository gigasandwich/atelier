package test;

import dao.TechnicienDao;
import model.Technicien;

import java.util.List;

public class TestTechnicien {
    public static void main(String[] args) {
        TechnicienDao technicienDao = new TechnicienDao();

        // Insert
        // Technicien newTechnicien = new Technicien(4, "Doe", "12345");
        // technicienDao.insert(newTechnicien);
        // System.out.println("Inserted new technicien: " + newTechnicien.getNomTechnicien());

        // Select
        List<Technicien> techniciens = technicienDao.selectAll();
        System.out.println("All techniciens:");
        for (Technicien technicien : techniciens) {
            System.out.println(technicien.getNomTechnicien() + " - " + technicien.getNumeroEmploye());
        }

        // Select by id
        Technicien selectedTechnicien = technicienDao.select(3);
        if (selectedTechnicien != null) {
            System.out.println("Selected technicien: " + selectedTechnicien.getNomTechnicien() + " - " + selectedTechnicien.getNumeroEmploye());
        } else {
            System.out.println("Technicien not found.");
        }

        // Update
        // Technicien updatedTechnicien = new Technicien(3, "Jane", "54321");
        // technicienDao.update(selectedTechnicien, updatedTechnicien);
        // System.out.println("Updated technicien: " + updatedTechnicien.getNomTechnicien());

        // Delete
        // technicienDao.delete(3);
        // System.out.println("Deleted technicien with ID 3");
    }
}
