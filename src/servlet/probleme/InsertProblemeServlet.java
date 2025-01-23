package servlet.probleme;
import dao.*;
import model.*;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "InsertionProbleme", urlPatterns = { "/insertion-probleme" })
public class InsertProblemeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageName", "/pages/insertion/probleme.jsp");
        request.getRequestDispatcher("/pages/accueil/accueil.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String descriptionProbleme = request.getParameter("descriptionProbleme");
        String categorieProbleme = request.getParameter("categorieProbleme");
        
        Probleme probleme = new Probleme(0, descriptionProbleme, categorieProbleme);

        ProblemeDao problemeDao = new ProblemeDao();
        problemeDao.insert(probleme);

        response.sendRedirect("/atelier/liste-probleme");
    }
}
