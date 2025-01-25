package dao;

import java.lang.reflect.Field;
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

    public static String convertEntityToJson(Object entity) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true); 
            try {
                Object value = field.get(entity);
                jsonBuilder.append("\"").append(field.getName()).append("\":");
                if (value instanceof String) {
                    jsonBuilder.append("\"").append(value).append("\"");
                } else {
                    jsonBuilder.append(value); 
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (i < fields.length - 1) {
                jsonBuilder.append(",");
            }
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    public static String convertEntityToJson(Object entity, int id) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        jsonBuilder.append("\"id\":").append(id).append(",");

        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            try {
                Object value = field.get(entity);
                jsonBuilder.append("\"").append(field.getName()).append("\":");
                if (value instanceof String) {
                    jsonBuilder.append("\"").append(value).append("\"");
                } else {
                    jsonBuilder.append(value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (i < fields.length - 1) {
                jsonBuilder.append(",");
            }
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

}   