package servlet;

import model.*;
import dao.*;
import html.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GenericInsert", urlPatterns = { "/insertion/*" }) // /insertion-client,
public class GenericInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
}
