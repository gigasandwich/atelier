package servlet.reparation;

import dao.ReparationDao;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet(name = "ListReparation", urlPatterns = { "/liste-reparation" })
public class ListReparationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageName", "/pages/liste/reparation.jsp");
        request.getRequestDispatcher("/pages/accueil/accueil.jsp").forward(request, response);
    }
}
