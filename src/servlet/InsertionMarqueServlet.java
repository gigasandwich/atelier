package servlet;

import connection.ConnectionPostgres;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Marque;

@WebServlet(name = "InsertionMarqueServlet", urlPatterns = {"/insertion-marque"})
public class InsertionMarqueServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = ConnectionPostgres.getConnection()) {
            // Récupérer toutes les marques depuis la base de données
            List<Marque> marque = new Marque().getAll(connection);

            // Ajouter les marques à la requête pour affichage
            request.setAttribute("marque", marque);

            // Rediriger vers la page d'insertion
            request.getRequestDispatcher("/pages/insertion/insertion-marque.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InsertionMarqueServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la recuperation de la page insertion-marque");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomMarque = request.getParameter("nomMarque");

        if (nomMarque == null || nomMarque.trim().isEmpty()) {
            request.setAttribute("error", "Le nom de la marque est obligatoire.");
            request.getRequestDispatcher("/pages/insertion/insertion-marque.jsp").forward(request, response);
            return;
        }

        try (Connection connection = ConnectionPostgres.getConnection()) {
            // Créer une nouvelle marque et l'insérer dans la base de données
            Marque marque = new Marque();
            marque.setNomMarque(nomMarque);
            marque.insert(connection);

            // Rediriger vers la liste des marques après insertion
            response.sendRedirect(request.getContextPath() + "/insertion-marque");
        } catch (SQLException ex) {
            Logger.getLogger(InsertionMarqueServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("error", "Echec de l'insertion de la marque. Veuillez reessayer.");
            request.getRequestDispatcher("/pages/insertion/insertion-marque.jsp").forward(request, response);
        }
    }
}