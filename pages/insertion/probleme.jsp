<%@ page import="dao.ClientDao" %>
<%@ page import="model.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!-- Line Awesome section start -->
<section id="line-awesome-icons">
  <div class="row">
    <div class="col-12">
      <div class="card">
        <div class="card-header">
          <h4 class="card-title">Insertion d'un nouveau probleme</h4>
          <a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a>
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
            <form action="insertion-probleme" method="POST">
              <div class="form-group">
                <label for="descriptionProbleme">Description du probleme:</label>
                <input type="text" id="descriptionProbleme" name="descriptionProbleme" class="form-control" required>
              </div>
              <div class="form-group">
                <label for="categorieProbleme">Categorie du probleme:</label>
                <input type="text" id="categorieProbleme" name="categorieProbleme" class="form-control" required>
              </div>
              <button type="submit" class="btn btn-primary">Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- // Line Awesome section end -->