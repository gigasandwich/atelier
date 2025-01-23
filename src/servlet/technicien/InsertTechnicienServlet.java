package servlet.technicien;
import dao.*;
import model.*;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "InsertionTechnicien", urlPatterns = { "/insertion-technicien" })
public class InsertTechnicienServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageName", "/pages/insertion/technicien.jsp");
        request.getRequestDispatcher("/pages/accueil/accueil.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String nomTechnicien = request.getParameter("nom_technicien");
        String numeroEmploye = request.getParameter("numero_employe");

        Technicien technicien = new Technicien(0, nomTechnicien, numeroEmploye);

        TechnicienDao technicienDao = new TechnicienDao();
        technicienDao.insert(technicien);

        response.sendRedirect("/atelier/liste-technicien");
    }
}
