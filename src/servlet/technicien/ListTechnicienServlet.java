package servlet.technicien;
import dao.*;
import model.*;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ListTechnicien", urlPatterns = { "/liste-technicien" })
public class ListTechnicienServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.setAttribute("pageName", "/pages/liste/technicien.jsp");
        request.setAttribute("pageName", "/pages/insertion/technicien.jsp");
        request.getRequestDispatcher("/pages/accueil/accueil.jsp").forward(request, response);
    }
    
}
