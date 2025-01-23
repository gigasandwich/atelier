<%@ page import="java.util.List" %>
<%@ page import="model.Reparation" %>
<%@ page import="dao.ReparationDao" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%
    ReparationDao reparationDao = new ReparationDao();
    List<Reparation> reparations = reparationDao.selectAll();
%>

<section id="line-awesome-icons">
  <div class="row">
    <div class="col-12">
      <div class="card">
        <div class="card-header">
          <h4 class="card-title">Liste des Réparations</h4>
          <div class="heading-elements">
            <ul class="list-inline mb-0">
              <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
              <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
              <li><a data-action="close"><i class="ft-x"></i></a></li>
            </ul>
          </div>
        </div>

        <div class="card-content collapse show">
          <div class="card-body">
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Description</th>
                  <th>Date Dépôt</th>
                  <th>Date Retour</th>
                  <th>Coût</th>
                  <th>Statut</th>
                  <th>Technicien</th>
                  <th>Problème</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                <%
                  for (Reparation reparation : reparations) {
                %>
                <tr>
                  <td><%= reparation.getIdReparation() %></td>
                  <td><%= reparation.getDescriptionSolution() %></td>
                  <td><%= reparation.getDateDepot() %></td>
                  <td><%= reparation.getDateRetour() %></td>
                  <td><%= reparation.getCoutReparation() %></td>
                  <td><%= reparation.getStatutReparation() %></td>
                  <td><%= reparation.getIdTechnicien() %></td>
                  <td><%= reparation.getIdProbleme() %></td>
                  <td>
                    <a href="edit.jsp?id=<%= reparation.getIdReparation() %>">Edit</a> |
                    <a href="delete.jsp?id=<%= reparation.getIdReparation() %>">Delete</a>
                  </td>
                </tr>
                <%
                  }
                %>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
