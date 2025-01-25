package dao;

import model.*;

public class DaoModelUtil {

    public static Class<?> getModelClass(String model) {
        switch (model) {
            case "client":
                return Client.class;
            case "ordinateur":
                return Ordinateur.class;
            case "marque":
                return Marque.class;
            case "modele":
                return Modele.class;
            case "type_ordinateur":
                return TypeOrdinateur.class;
            case "processeur":
                return Processeur.class;
            case "ram":
                return Ram.class;
            case "stockage":
                return Stockage.class;
            case "probleme":
                return Probleme.class;
            case "technicien":
                return Technicien.class;
            case "carte_graphique":
                return CarteGraphique.class;
            case "reparation":
                return Reparation.class;
            default:
                return null;
        }
    }

    public static GenericDaoImpl<?> getDao(String model) {
        switch (model) {
            case "client":
                return new ClientDao();
            case "ordinateur":
                return new OrdinateurDao();
            case "marque":
                return new MarqueDao();
            case "modele":
                return new ModeleDao();
            case "type_ordinateur":
                return new TypeOrdinateurDao();
            case "processeur":
                // return new ProcesseurDao();
                return null;
            case "ram":
                // return new RamDao();
                return null;
            case "stockage":
                // return new StockageDao();
                return null;
            case "probleme":
                return new ProblemeDao();
            case "technicien":
                return new TechnicienDao();
            case "carte_graphique":
                return new CarteGraphiqueDao();
            case "reparation":
                return new ReparationDao();
            default:
                return null;
        }
    }

    public static String convertSnakeToCamel(String snakeCase) {
        StringBuilder result = new StringBuilder();
        String[] parts = snakeCase.split("_");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].length() > 0) {
                if (i == 0) {
                    result.append(parts[i].toLowerCase());
                } else {
                    result.append(Character.toUpperCase(parts[i].charAt(0)));
                    result.append(parts[i].substring(1).toLowerCase());
                }
            }
        }
        return result.toString();
    }
}