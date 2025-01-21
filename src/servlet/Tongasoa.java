package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet(name = "Tongasoa", urlPatterns = { "/" })
public class Tongasoa extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageName", "/pages/blank.jsp");
        request.getRequestDispatcher("/pages/accueil/accueil.jsp").forward(request, response);
    }

}
