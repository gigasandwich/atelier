<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page import="dao.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%
    TechnicienDao technicienDao = new TechnicienDao();
    List<Technicien> techniciens = technicienDao.selectAll();
%>

<!-- Line Awesome section start -->
<section id="line-awesome-icons">
  <div class="row">
    <div class="col-12">
      <div class="card">
        <div class="card-header">
          <h4 class="card-title">Client List</h4>
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
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>NOM</th>
                  <th>NUMERO</th>
                </tr>
              </thead>
              <tbody>
                <%
                  for (Technicien technicien : techniciens) {
                %>
                <tr>
                  <td><%= technicien.getIdTechnicien() %></td>
                  <td><%= technicien.getNomTechnicien() %></td>
                  <td><%= technicien.getNumeroEmploye() %></td>
                  <td>
                    <!-- Action buttons for editing or deleting -->
                    <a href="edit.jsp?id=<%= technicien.getIdTechnicien() %>">Edit</a> |
                    <a href="delete.jsp?id=<%= technicien.getIdTechnicien() %>">Delete</a>
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
<!-- // Line Awesome section end -->
