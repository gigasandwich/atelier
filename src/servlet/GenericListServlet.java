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
import java.util.List;

@WebServlet(name = "GenericList", urlPatterns = { "/liste/*" })
public class GenericListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // /client

        if (pathInfo == null || pathInfo.length() <= 1) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid URL pattern.");
            return;
        }

        String modelName = pathInfo.substring(1); // client

        Class<?> modelClass = DaoModelUtil.getModelClass(modelName);
        GenericDaoImpl<?> dao = DaoModelUtil.getDao(modelName);

        if (modelClass == null || dao == null) {
            response.sendError(404, "Model not found: " + modelName);
            return;
        }

        List<?> entities = dao.selectAll();
        String tableHtml = ListGenerator.generateTable(entities);
        request.setAttribute("tableHtml", tableHtml);
        request.setAttribute("modelName", modelName);
        request.setAttribute("pageName", "/pages/generic/liste.jsp"); 
        request.getRequestDispatcher("/pages/template.jsp").forward(request, response);
    }
}
