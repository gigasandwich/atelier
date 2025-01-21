// package test;

// import dao.OrdinateurDao;
// import model.Ordinateur;
// import model.Stockage;

// import java.util.List;

// public class TestOrdinateur {
//     public static void main(String[] args) {
//         OrdinateurDao ordinateurDao = new OrdinateurDao();

//         // Insert
//         // Ordinateur newOrdinateur = new Ordinateur(4, "SN123456", 1, 2, 3, 4, 5, 512.0f);
//         // ordinateurDao.insert(newOrdinateur);
//         // System.out.println("Inserted new ordinateur: " + newOrdinateur.getNumeroSerie());

//         // Select
//         List<Ordinateur> ordinateurs = ordinateurDao.selectAll();
//         System.out.println("All ordinateurs:");
//         for (Ordinateur ordinateur : ordinateurs) {
//             System.out.println(ordinateur.getNumeroSerie());
//             Stockage stockage = ordinateur.getStockage();
//             if (stockage != null) {
//                 System.out.println("Stockage: " + stockage.getQuantiteStockage() + " " + stockage.getTypeStockage());
//             } else {
//                 System.out.println("No stockage found.");
//             }
//         }

//         // Select by id
//         Ordinateur selectedOrdinateur = ordinateurDao.select(3);
//         if (selectedOrdinateur != null) {
//             System.out.println("Selected ordinateur: " + selectedOrdinateur.getNumeroSerie());
//             Stockage stockage = selectedOrdinateur.getStockage();
//             if (stockage != null) {
//                 System.out.println("Stockage: " + stockage.getQuantiteStockage() + " " + stockage.getTypeStockage());
//             } else {
//                 System.out.println("No stockage found.");
//             }
//         } else {
//             System.out.println("Ordinateur not found.");
//         }

//         // Update
//         // Ordinateur updatedOrdinateur = new Ordinateur(3, "SN654321", 1, 2, 3, 4, 5, 1024.0f);
//         // ordinateurDao.update(selectedOrdinateur, updatedOrdinateur);
//         // System.out.println("Updated ordinateur: " + updatedOrdinateur.getNumeroSerie());

//         // Delete
//         // ordinateurDao.delete(3);
//         // System.out.println("Deleted ordinateur with ID 3");
//     }
// }
