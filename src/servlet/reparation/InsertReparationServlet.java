package servlet.reparation;

import dao.ReparationDao;
import model.Reparation;

import java.io.IOException;
import java.sql.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "InsertClient", urlPatterns = { "/insertion-reparation" })
public class InsertReparationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageName", "/pages/insertion/reparation.jsp");
        request.getRequestDispatcher("/pages/accueil/accueil.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descriptionSolution = request.getParameter("descriptionSolution");
        Date dateDepot = Date.valueOf(request.getParameter("dateDepot"));
        Date dateRetour = Date.valueOf(request.getParameter("dateRetour"));
        float coutReparation = Float.parseFloat(request.getParameter("coutReparation"));
        String statutReparation = request.getParameter("statutReparation");
        int idTechnicien = Integer.parseInt(request.getParameter("idTechnicien"));
        int idProbleme = Integer.parseInt(request.getParameter("idProbleme"));

        Reparation reparation = new Reparation(0, descriptionSolution, dateDepot, dateRetour, coutReparation, statutReparation, idTechnicien, idProbleme);
        ReparationDao reparationDao = new ReparationDao();
        reparationDao.insert(reparation);

        response.sendRedirect("/atelier/liste-reparation");
    }
}
