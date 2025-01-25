<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<section id="line-awesome-icons">
  <div class="row">
    <div class="col-12">
      <div class="card">
        <div class="card-header">
          <h4 class="card-title">Inserer un nouveau <%= request.getAttribute("modelName") %></h4>
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
            <%= request.getAttribute("formHtml") %>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
