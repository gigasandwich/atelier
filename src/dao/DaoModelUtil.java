package dao;

import dao.*;
import model.*;

public class DaoModelUtil {

    public static Class<?> getModelClass(String model) {
        switch (model) {
            case "client":
                return Client.class;
            case "ordinateur":
                return Ordinateur.class;
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
            default:
                return null;
        }
    }
}