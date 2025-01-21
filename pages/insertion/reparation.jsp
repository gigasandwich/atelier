<%@ page import="dao.ReparationDao" %>
<%@ page import="model.Reparation" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<section id="line-awesome-icons">
  <div class="row">
    <div class="col-12">
      <div class="card">
        <div class="card-header">
          <h4 class="card-title">Insertion d'une Nouvelle Réparation</h4>
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
            <form action="insertion-reparation" method="POST">
              <div class="form-group">
                <label for="descriptionSolution">Description de la Solution:</label>
                <input type="text" id="descriptionSolution" name="descriptionSolution" class="form-control" required>
              </div>
              <div class="form-group">
                <label for="dateDepot">Date de Dépôt:</label>
                <input type="date" id="dateDepot" name="dateDepot" class="form-control" required>
              </div>
              <div class="form-group">
                <label for="dateRetour">Date de Retour:</label>
                <input type="date" id="dateRetour" name="dateRetour" class="form-control" required>
              </div>
              <div class="form-group">
                <label for="coutReparation">Coût de la Réparation:</label>
                <input type="number" step="0.01" id="coutReparation" name="coutReparation" class="form-control" required>
              </div>
              <div class="form-group">
                <label for="statutReparation">Statut:</label>
                <input type="text" id="statutReparation" name="statutReparation" class="form-control" required>
              </div>
              <div class="form-group">
                <label for="idTechnicien">ID du Technicien:</label>
                <input type="number" id="idTechnicien" name="idTechnicien" class="form-control" required>
              </div>
              <div class="form-group">
                <label for="idProbleme">ID du Problème:</label>
                <input type="number" id="idProbleme" name="idProbleme" class="form-control" required>
              </div>
              <button type="submit" class="btn btn-primary">Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
