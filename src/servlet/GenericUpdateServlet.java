package servlet;

import model.*;
import dao.*;
import html.*;

import java.lang.reflect.Field;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GenericUpdate", urlPatterns = { "/edit/*" }) // /edit-client
public class GenericUpdateServlet<T> extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // "/client"

        if (pathInfo == null || pathInfo.length() <= 1) {
            response.sendError(400, "Invalid URL pattern."); // Bad request
            return;
        }

        String modelName = pathInfo.substring(1); // client
        Class<T> modelClass = (Class<T>) DaoModelUtil.getModelClass(modelName);

        if (modelClass == null) {
            response.sendError(404, "Model not found: " + modelName);
            return;
        }

        String idParam = request.getParameter("id");
        if (idParam == null) {
            response.sendError(400, "ID parameter is missing.");
            return;
        }

        try {
            GenericDaoImpl<T> dao = (GenericDaoImpl<T>) DaoModelUtil.getDao(modelName);
            int id = Integer.parseInt(idParam);
            T entity = dao.select(id);

            if (entity == null) {
                response.sendError(404, "Entity not found.");
                return;
            }

            // Generate the form with the current values
            String formHtml = FormGenerator.generateForm(modelClass, entity);
            request.setAttribute("formHtml", formHtml);
            request.setAttribute("modelName", modelName);
            request.setAttribute("pageName", "/pages/generic/edit.jsp");
            request.getRequestDispatcher("/pages/template.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(500, "Error processing the request: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // "/client"
        String modelName = pathInfo.substring(1); // client
        Class<T> modelClass = (Class<T>) DaoModelUtil.getModelClass(modelName);

        if (modelClass == null) {
            response.sendError(404, "Model not found: " + modelName);
            return;
        }

        try {
            GenericDaoImpl<T> dao = (GenericDaoImpl<T>) DaoModelUtil.getDao(modelName);
            String[] updateColumns = dao.getInsertColumnsArray();

            String idParam = request.getParameter("id");
            if (idParam == null) {
                response.sendError(400, "ID parameter is missing.");
                return;
            }
            int id = Integer.parseInt(idParam);

            // Fetch the existing entity
            T entity = dao.select(id);
            if (entity == null) {
                response.sendError(404, "Entity not found.");
                return;
            }

            // Populate parameters based on the request
            Field[] fields = modelClass.getDeclaredFields();
            for (String columnName : updateColumns) {
                String value = request.getParameter(DaoModelUtil.convertSnakeToCamel(columnName));
                for (Field field : fields) {
                    if (field.getName().equalsIgnoreCase(DaoModelUtil.convertSnakeToCamel(columnName))) {
                        field.setAccessible(true);
                        Class<?> fieldType = field.getType();
                        if (fieldType == int.class) {
                            field.set(entity, Integer.parseInt(value));
                        } else if (fieldType == String.class) {
                            field.set(entity, value);
                        }
                        break;
                    }
                }
            }

            dao.update(entity);
            response.sendRedirect(request.getContextPath() + "/liste/" + modelName);
        } catch (Exception e) {
            response.sendError(500, "Error processing the request: " + e.getMessage());
        }
    }
}