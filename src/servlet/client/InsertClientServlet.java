package servlet.client;
import dao.*;
import model.*;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "InsertClient", urlPatterns = { "/insertion-client" })
public class InsertClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageName", "/pages/insertion/client.jsp");
        request.getRequestDispatcher("/pages/accueil/accueil.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String nomClient = request.getParameter("nomClient");
        String prenomClient = request.getParameter("prenomClient");
        String contact = request.getParameter("contact");

        // Create a new Client object
        Client client = new Client(0, nomClient, prenomClient, contact);

        // Insert the new client using the DAO
        ClientDao clientDao = new ClientDao();
        clientDao.insert(client);

        // Redirect to client list
        response.sendRedirect("/atelier/liste-client");
    }
}
