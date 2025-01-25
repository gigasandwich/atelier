package servlet;

import dao.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GenericDelete", urlPatterns = { "/delete/*" }) // /delete-client
public class GenericDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // "/client"
        String modelName = pathInfo.substring(1); // client

        String idParam = request.getParameter("id");
        if (idParam == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID parameter is missing.");
            return;
        }

        try {
            int id = Integer.parseInt(idParam);

            GenericDaoImpl<?> dao = DaoModelUtil.getDao(modelName);
            if (dao == null) {
                response.sendError(404, "Model not found: " + modelName);
                return;
            }

            dao.delete(id);

            response.sendRedirect(request.getContextPath() + "/liste/" + modelName);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "Error processing the request: " + e.getMessage());
        }
    }
}