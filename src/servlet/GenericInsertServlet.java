package servlet;

import model.*;
import dao.*;
import html.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.lang.reflect.Field;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GenericInsert", urlPatterns = { "/insertion/*" }) // /insertion-client,
public class GenericInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // "/client"

        if (pathInfo == null || pathInfo.length() <= 1) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid URL pattern.");
            return;
        }

        String modelName = pathInfo.substring(1); // client
        Class<?> modelClass = DaoModelUtil.getModelClass(modelName);

        if (modelClass == null) {
            response.sendError(404, "Model not found: " + modelName);
            return;
        }

        String formHtml = FormGenerator.generateForm(modelClass);
        request.setAttribute("formHtml", formHtml);
        request.setAttribute("modelName", modelName);
        request.setAttribute("pageName", "/pages/generic/insertion.jsp");
        request.getRequestDispatcher("/pages/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // "/client"
        String modelName = pathInfo.substring(1); // client
        Class<?> modelClass = DaoModelUtil.getModelClass(modelName);

        if (modelClass == null) {
            response.sendError(404, "Model not found: " + modelName);
            return;
        }

        try {
            GenericDaoImpl<?> dao = DaoModelUtil.getDao(modelName);
            String[] insertColumns = dao.getInsertColumnsArray();

            Object[] params = new Object[insertColumns.length];
            Field[] fields = modelClass.getDeclaredFields();

            // Populate parameters based on the request
            for (int i = 0; i < insertColumns.length; i++) {
                String columnName = insertColumns[i];
                String value = request.getParameter(DaoModelUtil.convertSnakeToCamel(columnName));
                for (Field field : fields) {
                    if (field.getName().equalsIgnoreCase(DaoModelUtil.convertSnakeToCamel(columnName))) {
                        field.setAccessible(true);
                        Class<?> fieldType = field.getType();
                        if (fieldType == int.class) {
                            params[i] = Integer.parseInt(value);
                        } else if (fieldType == String.class) {
                            params[i] = value;
                        }
                        break;
                    }
                }
            }

            dao.insert(params);
            response.sendRedirect(request.getContextPath() + "/liste/" + modelName);
        } catch (Exception e) {
            response.sendError(500, "Error processing the request." + e.getMessage());
        }
    }
}
